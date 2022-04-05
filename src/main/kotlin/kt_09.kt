/**
 * Description:
 * Created by small small su
 * Date: 2022/4/2
 * Email: surao@foryou56.com
 */
class KtBase70 {
    var name = "Derry"

    /**
     *  背后的事情:
     *  private String name = "Derry"
     *
     *  @notnull
     *  public void setName(@notNull String name){
     *      this.name = name;
     *  }
     *
     *
     */
    var value = "ABCDEFG"
        get() = field
        set(value) {
            field = value
        }

    //会默认提供 get() = field
    //会默认提供  set(value){ field = value }

    var info = "abcdefg"
        get() = field.capitalize()
        set(value) {
            field = "[$value]"
        }

    // TODO: 2022/4/2 计算属性
    //只读 没有set函数
    val number: Int = 0

    /**
     *  背后代码
     *  private int number = 0 ;
     */

    //这样写 覆盖了get函数中的field，所以 不能给值 ，不能用 =初始化
    val number2: Int
        get() = (1..1000).shuffled().first() //1到1000 随机值
    // 为什么没看到number2的java代码中的定义：
    // 因为 属于计算属性 的功能，根本在getNumber2函数里面没有用到number2的属性，所以number2的属性失效了

    // TODO: 2022/4/2 防范静态条件
    // 当你调用成员，可能为null，可能为""，就必须采用防范静态条件，这是kt的规范
    var info2: String? = ""
    fun getShowInfo(): String {
        //这种写法就是 防范静态条件 专业kt开发 有大量这样代码
        return info2?.let {
            if (it.isBlank()) {
                "it是空值"
            } else {
                "最终info结果是:$it"
            }
        } ?: "你原来是null，请检查代码"
    }
}

fun main() {
    //背后隐式代码 new KtBase70().setName("Kevin")
    KtBase70().name = "Kevin"
    // System.out.println( new KtBase70().getName());
    println(KtBase70().name)

    println(KtBase70().info)

//    KtBase70().number = 9 报错了，val 根本没有setXXX函数，只有get函数

    println("number2： " + KtBase70().number2)
    println(KtBase70().getShowInfo())


}