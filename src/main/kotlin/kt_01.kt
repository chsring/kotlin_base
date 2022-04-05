/**
 * Description:
 * Created by small small su
 * Date: 2022/3/17
 * Email: surao@foryou56.com
 */

const val PI = 3.14
//定义 编译时常量 只能定义函数外，就可以在编译期间初始化 。why？ 如果在函数内定义，只能在函数运行时调用才能赋值

fun main() {

// TODO: 2022/3/17 Kotlin 的类型推断
    val info: String = "info"  //只读 不能修改

    val age: Int = 98

    println(age)

    val xxx = "t"
    val ss = 55.4

    // TODO: 2022/3/17 编译时候的常量
    val a = "sss" //这个是只读类型的变量，而不是变异时常量
    //基本数据类型 String Double Int Float Long Short Byte Char Boolean
    // const val PI = 45  const 不适用于局部变量

    // TODO: 2022/3/17 查看kotlin 反编译后的字节码
    /**
     * 不用担心性能问题，无论什么类型，最终转成 jvm 适合的类型
     *Tools  -》  kotlin  --》 show byte code
     *
     */

    // TODO: 2022/3/17 引用类型的学习 引用类型 不会耗费性能 最终转成java的基本类型
    val age_1: Int = 99
    val pi: Float = 3.222f
    val pi2: Double = 3.2222

    // TODO: 2022/3/17  range  表达式 实际上是一个操作符 ..
    // java 中 if 是语句 ， kotlin 中if 是表达式，又返回值的
    val numnber = 148
    if (numnber in 10..59) {
        println("10到59")
    } else if (numnber in 0..9) {
        println("0到10")
    } else {
        println("很好")
    }

    // TODO: 2022/3/17 when 表达式
    val week = 6

    //info2 返回 Any 类型 相当于 java的 Object 类型；如果else返回String ，则info2为String
    val info2 = when (week) {
        1 -> "今天是星期一"
        2 -> "今天是星期一 "
        3 -> "今天是星期一  "
        4 -> "今天是星期一   "
        5 -> "今天是星期一    "
        else -> {
            println("ss")
        }
    }
    println(info2)
    //打印 Unit 类型，是一个类，相当于java的void关键字

    // TODO: 2022/3/17 字符串模板

    val garden = "黄石公园"
    val time = 6
    println("今天天气很晴朗，去" + garden + "完,完了$time 小时")
    println("今天天气很晴朗，去${garden}完,完了$time 小时")

    val isLogin = true
    println("server response:${if (isLogin) "恭喜你，登录成功" else "登录失败"}")

    action01(9, "ll")
    action01(9)
    action02()
    action02(10)

    loginAction(age = 99, number = "ss", userName = "22", userPwd = "sdf")

    println(doWork())
    `卜哥看这个方法名字奇怪吗`(garden,time)
}

// TODO: 2022/3/17 函数头的学习  函数默认都是public
// kt的函数更规范，现有输入，再有输出
private fun method01(age: Int, name: String): Int/* 这个Int 是返回类型*/ {
    println("姓名：$age,年龄$name")
    return 200
}

/** 相当于
 * private static final int method01(int age,String name){
 * }
 */
// TODO: 2022/3/17 函数中默认参数
private fun action01(age: Int, name: String = "sss") {
    println("action01---姓名：$age,年龄$name")
}

private fun action02(age: Int = 77, name: String = "sss") {
    println("action 02 ---姓名：$age,年龄$name")
}

// TODO: 2022/3/17  具名函数参数 体现在调用时候
private fun loginAction(userName: String, userPwd: String, number: String, age: Int) {
    println("username:$userName,userPwd:$userPwd,number:$number,age$age")
}

// TODO: 2022/3/17  21 课Unit 函数特点
//Unit不写，默认也有，相当于java语言的void关键字,关键字无法打印处理，而Unit是类，可以打印处理
private fun doWork(): Unit {
    return println()
}

// TODO: 2022/3/17  Nothing 类型
private fun show(number: Int) {
    when (number) {
        // 返回Nothing 类，相当于抛出异常
        -1 -> TODO("没这种函数")
        in 0..59 -> println("分数不及格")
        in 60..70 -> println("分数及格")
        in 71..100 -> println("优秀")
    }
}

interface A {
    fun show()
}

class AImpl : A {
    override fun show() {
        //下面这句话 不是注释提示，要去掉，不去掉会终止程序
        TODO("Not yet implemented")
    }
}

// TODO: 2022/3/17 反引号中函数名特点，3中情况
private fun `卜哥看这个方法名字奇怪吗`(name: String, pwd: Int) {
    //情况1
    println("用户名$name,密码$pwd")
    //情况2 引用java中in或者is （在kt中是关键字）使用反引号
    KtBase21.`in`()
}

private fun `4444`(){
    //很复杂的功能
    //公司加密文档 对此函数作用进行了说明，防止反编译
}

