/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/5 reified 关键字
data class ObjClass1(val name: String, val age: Int, val study: String)
data class ObjClass2(val name: String, val age: Int, val study: String)
data class ObjClass3(val name: String, val age: Int, val study: String)

class KtBase112<T> {
    //  所有的功能 写在函数上.默认产生一个对象,
    //  如果此对象和用户指定对象不一致，我们就启用备用对象，否则就直接返回对象
    inline fun <reified T> randomOrDefault(defaultAction: () -> T): T {
        val objList: List<Any> = listOf(
            ObjClass1("obj1 lisi", 22, "study C"),
            ObjClass2("obj2 wangzu", 23, "study Java"),
            ObjClass2("obj3 zhaosi", 24, "study C++")
        )
        val randomObj: Any = objList.shuffled().first()
        println("随机产生的是：$randomObj")
        return randomObj.takeIf { it is T } as T?  // T 和 T？是有区别的
            ?: defaultAction()
    }
}

fun main() {
    val p = KtBase112<ObjClass1>().randomOrDefault {
        println("由于随机产生的对象 和指定的 obj1 不一致，所以使用备用对象")
        ObjClass1("obj1 lisi", 22, "study C")
    }
    println("客户端最终结果 :$p")

}