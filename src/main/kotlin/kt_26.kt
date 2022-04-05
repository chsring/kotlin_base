import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/5  扩展函数 扩展超类 扩展范型 扩展属性
// TODO: 2022/4/5 扩展函数,不能重复定义
//假设这个代码是 开源的 ，庞大的jdk源码，或者非常复杂的开源库,或者加密收费的
class KtBase113(val name: String, val age: Int, val sex: Char) {}

//扩展函数 KtBase113.xxx   xxx函数会持有this == KtBase113 对象类本身
fun KtBase113.show() {
    println("我是show函数， name:${this.name},age:${this.age},sex:$this.sex")
}

fun KtBase113.getInfo() = "我是show函数， name:${this.name},age:${this.age},sex:$this.sex"

//对 String 扩展
fun String.addExtActionj(number: Int) = this + "@".repeat(number)

/**
 * 增加扩展函数后的 背后代码 会新建一个类，把扩展出来的方法加到类里面
 * public final class KtBase113Kt{
 *      // 会新增
 *      public static final void show(){
 *          ...
 *      }
 *      public static  void main(String[] args){
 *          ...
 *      }
 *  }
 */

// TODO: 2022/4/5 超类上定义扩展函数
data class ResponseResult1(val msg: String, var code: Int)
data class ResponseResult2(val msg: String, var code: Int)

//很恐怖，对超类扩展
fun Any.showPrintlnContent() = println("当前的内容是:$this")


//很恐怖，对超类扩展
fun Any.showPrintlnContent2(): Any {
    println("当前的内容是:$this")
    return this
}

// TODO: 2022/4/5 kotlin 内置的扩展函数，被我们重复定义，属于覆盖，而且优先使用我们自己的
public fun File.getAbsolutePath(): String {
    return "str"
}

fun commonFun() {}

// TODO: 2022/4/5 对范型 扩展,对范型扩展后，所有类型都能使用
fun <T> T.showContentInfo() = println("${if (this is String) "你的字符串长度 ${this.length}" else "你不是字符串，你的内容是${this}"}")

fun <T> T.showTime() = println("当前时间是：${System.currentTimeMillis()}")

fun <INPUTTYPE> INPUTTYPE.showAction(): String =
    when (this) {
        is String -> "原来你是String"
        is Int -> "原来你是Int"
        is Char -> "原来你是Char"
        is Double -> "原来你是Double"
        is Boolean -> "原来你是Boolean"
        is Unit -> "原来你是函数类型"
        else -> "未知类型"
    }

// TODO: 2022/4/5 对属性 扩展
val myStr: String = "AAA"
/*背后代码:
    public final class KtBase117Kt{
        @NotNull
        private static final String myStr = "AAA";
        @NotNull
        public static String getMyStr(){
             return myStr;
        }

        main()... 会在这个类里面执行main函数 交给jvm
    }
 */

val String.myInfo: String
    get() = "Derry"
/*背后代码:
    public final class KtBase117Kt{

        @NotNull
        public static final String getMyInfo(String $this$myInfo){
             Intrinsics.checkParameTerIsNotNull( $this$myInfo , "$this$myInfo" )
             return "Derry";
        }
    }
 */

// 只有String有资格 打印输出 并且链式调用
fun String.showPrint(): String {
    println("只有String有资格 打印输出 并且链式调用 ：$this")
    return this
}

val String.stringAllInfo: String
    get() = "当前：${System.currentTimeMillis()} 这个时间点 被调用了，当前值是：$this,当前长度是：$length "

//增加扩展函数
fun main() {
    val p = KtBase113("张三", 28, '男')
    p.show()
    println("Dev".addExtActionj(5))

    ResponseResult1("login success", 200).showPrintlnContent()
    ResponseResult2("login success", 200)
        .showPrintlnContent2()
        .showPrintlnContent2()
        .showPrintlnContent()

    345.showContentInfo()
    'C'.showContentInfo()
    false.showContentInfo()
    345.4.showContentInfo()
    "Derry".showContentInfo()
    commonFun().showContentInfo()

    345.showTime()
    'C'.showTime()
    false.showTime()
    345.4.showTime()
    "Derry".showTime()

    println(345.showAction())
    println('C'.showAction())
    println(false.showAction())
    println(345.4.showAction())
    println("Derry".showAction())
    println(commonFun().showAction())

    // TODO: 2022/4/5 扩展属性

    var str: String = "ABC"
    println("扩展属性：$str.myInfo")

    // 只有String有资格 打印输出 并且链式调用
    str.showPrint().showPrint().showPrint()

    //扩展属性+扩展函数+链式调用
    "  Derr ".stringAllInfo.showPrint().showPrint()
}