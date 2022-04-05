/**
 * Description:
 * Created by small small su
 * Date: 2022/3/31
 * Email: surao@foryou56.com
 */

fun main() {
    // TODO: 2022/3/31 List

    val list: List<String> = listOf("张三", "里斯", "王武")

    val list1 = listOf("张三", "里斯", "王武")
//    list1.add  不可变，无此功能

    println(list[0]) //本质是运算符重载
    println(list[2])
    //我们写kt代码 一定不会出现 空指针异常，下标越界异常！！
    println(list.getOrElse(4) { "越界" })
    println(list.getOrNull(4))
    println(list.getOrNull(4) ?: "你越界了")

    // TODO: 2022/3/31 可变list集合

    val list2: MutableList<String> = mutableListOf<String>("Derry", "zhangsna", "wangwu")

    val list3 = mutableListOf("Derry", "zhangsna", "wangwu")
    list3.add("找刘")
    list3.remove("zhangsna")

    //转可变
    val list4: MutableList<String> = list.toMutableList()
    println(list4)

    //转不可变
    val list5 = list4.toList() //

    // TODO: 2022/3/31 mutator 函数 += -= removeIf (运算符重载)
    val list6 = mutableListOf("Derry", "zhangsna", "wangwu")
    val list7 = list6
    val list8 = mutableListOf("Derry", "zhangsna", "wangwu")
    list6 += "里斯"
    list6 += "王武"
    list6 -= "Derry"
    println(list6)
    list6.removeIf {
        println("before remove if : $list6")
        true //自动遍历整个可变集合，进行一个个输出
    }
    println("remove if : $list6")

    println("list7 : $list7")
    println("list8 : $list8")
    list8.removeIf {
        it.contains("Derry") //过滤所有的元素
    }
    println("list8 : $list8")

    // TODO: 2022/3/31 遍历集合
    val list9 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(list9)//输出，不是遍历

    //第一种方式
    for (i in list) {
        println(" 第一种方式 ：元素：$i ")
    }
    //第二种方式
    list.forEach {
        println(" 第二种方式:元素：$it")
    }

    //第三种方式
    list.forEachIndexed { index, item ->
        println(" 第三种方式:元素：$item 下标$index")
    }

    // TODO: 2022/3/31 结构语法过滤问题

    val list10 = listOf("李元霸", "李小龙", "李连杰")
    val (value1, value2, value3) = list10
    println("value1:$value1, value2:$value2, value3:$value3")

    val (_, n2, n3) = list10 // _ 不是变量名 用来过滤结构 不接受赋值
    val (v1, _, v3) = list10 // _ 不是变量名 用来过滤结构 不接受赋值

    // TODO: 2022/3/31 set集合
    val set = setOf("lisi", "wangwu", "zhaoliu", "wangwu") //自动去重复
    println(set)
    println(set.elementAt(0))//没有set[0]

//    println(set.elementAt(3))// 会越界 为防止越界，尽量使用这个elementAtOrElse  elementAtOrNull
    println(set.elementAtOrElse(3) { 3 })
    println(set.elementAtOrNull(3))
    println(set.elementAtOrNull(3) ?: "为空了")

    // TODO: 2022/3/31 mutableSet 可变集合
    val set2 = mutableSetOf("lisi", "wangwu", "zhaoliu", "wangwu") //自动去重复
    set2 += "ss"
    set2 -= "444"
    set2.add("sdf")
    set2.remove("lisi")

    // TODO: 2022/4/1  集合转换快捷函数
    val list11 = mutableListOf("Derry", "Derry", "Leo", "Srwing")

    //去重
    val set10 = list11.toSet() //不可变的常规set集合
    println(set10)

    //去重
    println(list11.distinct())
    println(list11)

}