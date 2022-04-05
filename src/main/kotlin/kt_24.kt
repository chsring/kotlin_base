/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
// in T, out T 声明处范型，这个是 java 没有的功能
//todo 整个 SetClass 里面的所有成员 范型相关 只能更改，不能获取
class SetClass<in T>() {
    //内部的函数 只能 对T修改，不能获取

    fun set1(item: T) {
        println("set1 你要设置的item是:$item")
    }
//  如果 有 T 类型的返回值，便报错
//    fun get1():T?{
//        return null
//    }
}

//todo 整个 GetClass 里面的所有成员 范型相关 只能获取，不能修改
class GetClass<out T>(val item: T) {
    //内部的函数 只能 对T获取，不能修改T
//    fun set(item:T){
//
//    }

    fun get(): T {
        return item
    }
}

fun main() {
    // in 逆变 setClass 只能修改 不能读取
    val p1 = SetClass<String>()
    p1.set1("Derry")

    //out 协变 getClass 只能读取 不能修改
    val p2 = GetClass<String>("里斯")
    println(p2.get())

}
