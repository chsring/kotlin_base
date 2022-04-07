/**
 * Description:
 * Created by small small su
 * Date: 2022/4/7
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/7 kt 与 java的互操作 与可空
//    String!  java与kt交互的时候，Java给kt用的值都是 String！
//    只要是看到 类似于String！ 的类型，在使用的时候，必须 ?.xxx；如果忘记 就有风险

fun main() {
    val info1 = KtBase21().info  // info1 为 String！
    println(info1?.length)

    // todo 下面 java与kt交互 正确推荐; 看到String！ 必须用 val info2: String?
    val info2: String? = KtBase21().info
    println(info2?.length)
}