/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/4 范型类 
class KtBase103<T>(private val obj: T) {
    //万能输出器
    fun show() = println("万能输出器:$obj")
}

data class Student3(val name: String, val age: Int, val sex: Char)
data class Teacher(val name: String, val age: Int, val sex: Char)

// TODO: 2022/4/4 范型函数
class KtBase104<T>(private val isR: Boolean, private val obj: T) {

    fun getObj(): T? = obj.takeIf { isR }
    //takeIf ture 返回obj本身，false 返回null
}


fun main() {
    val stu1 = Student3("张三", 88, '女')
    val stu2 = Student3("里斯", 78, '男')
    val tea1 = Teacher("王武", 68, '男')
    val tea2 = Teacher("赵六", 58, '女')

    KtBase103(stu1).show()
    KtBase103(stu2).show()
    KtBase103(tea1).show()
    KtBase103(tea2).show()

    KtBase103(String("刘一".toByteArray())).show()
    KtBase103<Int>(555).show()
    KtBase103(555.4).show()
    KtBase103(555f).show()
    KtBase103("555").show()

    println(KtBase104(true, stu1).getObj())
    println(KtBase104(true, stu2).getObj())
    println(KtBase104(true, tea1).getObj())
    println(KtBase104(true, tea2).getObj())

    println(KtBase104(false, tea2).getObj() ?: "大哥，你返回了null")

    //3.对象 + run + ?: 如果不为null ，执行
    KtBase104(true, stu1).getObj()?.run {
        //如果 getObj 返回有值 ，不为null 就会执行到里面
        println(this)
    } ?: println("大哥 你的返回的是null")

    show4("Derry")
    show4("Kevin")
    show4("OK")
    show4(null)

}

fun <B> show4(item: B) {
    val r: Any = item?.also {
        //it == item 本身
        println("万能对象是 :$it")
    } ?: println("大哥，返回为空了")
}