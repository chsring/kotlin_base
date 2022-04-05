import randomItemPrint as ptT
import randomItem as pt

/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/5 对空类型 函数扩展

fun String?.outputStringValueFun() {}

fun String?.outputStringValueFun2(default: String) {
    println(this ?: default)
}

// TODO: 2022/4/5  infix自定义中缀表达式 需要加扩展函数一起用 c1 gogogog c2  或者  c1.gogogo(c2)
// 条件一 ： 对第一个参数 进行函数扩展
// 条件二 ： 需要在括号（c1,c2）里面传递一个参数
private infix fun <C1, C2> C1.gogogo(c2: C2) {
    println("表达式 第一个参数 $this, 第二个参数 $c2")
}

fun main() {
    val infoValue: String? = null
    val name: String = "Derry"
    infoValue.outputStringValueFun()
    name.outputStringValueFun()
    //String？可以接受 可空数据，也可以接受 有值得数据
    //String 只能接受 有值的数据 

    infoValue.outputStringValueFun2("我是 默认值")
    name.outputStringValueFun2("我是 默认值")

    // TODO: 2022/4/5 infix 关键字 就是中缀表达式 ，可以简化代码
    mapOf("-" to 1)
//    public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    mapOf("-".to(1))

    123.gogogo("男")
    12.3 gogogo "女"

    // TODO: 2022/4/5 扩展文件
    val list = listOf("李元霸", "李连杰", "李小龙")
    val set: Set<Double> = setOf(55.4, 22.3, 456.6)

    println(list.shuffled().first())
    println(set.shuffled().first())

    // TODO: 2022/4/5 重命名扩展
    list.pt()
    set.ptT()

}
