/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/4 []操作符学习 
class KtBase108<INPUT>(vararg objs: INPUT, val isR: Boolean = true) {
    private val objectArray: Array<out INPUT> = objs

    // 5种变化类型的解释
    fun getR1(): Array<out INPUT>? = objectArray.takeIf {
        isR
    }

    //涉及到混合类型的返回 Comparable<*> &java.io.Serializable，这种是写不出来的，所以用Any代替
    fun getR2(): Any = objectArray.takeIf { isR } ?: "你是null"

    fun getR3(): Any? = objectArray.takeIf { isR } ?: "你是null" ?: null

    fun getR4(index: Int): INPUT? = objectArray[index].takeIf { isR } ?: null

    fun getR5(index: Int): Any? = objectArray[index].takeIf { isR } ?: "AAA" ?: null

    operator fun get(index: Int): INPUT? = objectArray[index].takeIf { isR }
}

//范型 允许传null，可以接受很多类型，但是接受null后 要处理好
fun <INPUT> inputObj(item: INPUT) {
    //String? 除了可以接受String ，还可以接受null
    //一般处理范型接受，就用String？ 处理，规范化处理
    println((item as String?)?.length ?: "你传的null 啊")
}

fun main() {
    inputObj("Derry")
    inputObj("Kevin")
    inputObj(null)

    val p1: KtBase108<String?> = KtBase108("张三", "里斯", "王武", null)

    println(p1[0])
    println(p1[1])
    println(p1[2])
    println(p1[3])

    //var r: String = p1[0] 报错了 只要有一个元素是null，所有的元素都要用String？接受
    var r: String? = p1[0]

}