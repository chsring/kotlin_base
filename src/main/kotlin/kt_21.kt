/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/4 动态参数 vararg关键字
//动态参数的范型 可以传进一个null
class KtBase107<T>(vararg objects: T, var isMap: Boolean) {
    //out 只能被读取,objects被认为 不能被修改了
    val objArray: Array<out T> = objects

    fun showObj(index: Int): Any = objArray[index].takeIf { true } ?: "你的下标 ${index} 为null"

    fun <O> mapObj(index: Int, mapAction: (T?) -> O) = mapAction(objArray[index].takeIf { isMap })


}

fun main() {
    val p: KtBase107<Any?> = KtBase107("Derry", null, 'A', 444, 555.5, 6665f, false, isMap = true)

    println(p.showObj(0))
    println(p.showObj(1).toString())
    println(p.showObj(2))
    println(p.showObj(3))
    println(p.showObj(4))
    println(p.showObj(5))
    println(p.showObj(6))

    var r: Int = p.mapObj(0) {
        it
        it.toString()
        it.toString().length
    }

    println("第0哥元素的字符串长度 $r")

    var r2: String = p.mapObj(3) {
        "我的第三个元素是 $it"
    }

    println(r2)

    val p2: KtBase107<String> = KtBase107("aaa", "bbb", "ccc", isMap = true)
    //如果lambda 返回类型是 O R
    var r3 = p2.mapObj(2) {
        it.toString().length
    }
}





