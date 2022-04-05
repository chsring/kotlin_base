import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/3/29
 * Email: surao@foryou56.com
 */
// TODO: 2022/3/30 内置函数的总结 
fun main() {
    // TODO: 2022/3/30 appply内置函数
    val info = "Derry You Hao"
    println("info的长度是${info.length}")
    println("info的最后一个字符是${info[info.length - 1]}")
    println("info全部转成小写:${info.toLowerCase()}")

    //apply特点是 始终返回info本身
    val infoNew: String = info.apply {
        //一般大部分情况下，匿名函数都会持有一个it，但是apply函数不会持有it，却持有this（info本身）
        println("apply匿名函数打印的是:$this")
        println("info的长度是${length}")
        println("info的最后一个字符是${this[length - 1]}")
        println("info全部转成小写:${toLowerCase()}")
    }

    println("apply的返回数:$infoNew")

    //apply返回info本身的String类型，所以可以继续 .apply
    info.apply {
        println("info的最后一个字符是${this[length - 1]}")
    }.apply {
        println("info全部转成小写:${toLowerCase()}")
    }

    //应用场景
    val file = File("/Users/surao/Desktop/解压密码.txt")
    file.setExecutable(true)
    file.setReadable(true)
    println(file.readLines())

    //apply 始终返回 对象本身
    val fileNew: File = file.apply {
        setExecutable(true)
    }.apply {
        setReadable(true)
    }.apply {
        println(readLines())
    }

    // TODO: 2022/3/30 let内置函数
    //普通方式对集合第一个元素相加 let方式对集合第一个元素相加
    //普通方式对值判null并返回，let方式对值判null并返回
    val list: List<Int> = listOf(6, 5, 2, 3, 5, 7)
    val value1: Int = list.first()
    val result1 = value1 + value1;

    println("result : $result1")

    val result2: Int = listOf(6, 5, 2, 3, 5, 7).let {
        //it == list集合
        it.first() + it.first()
        //let函数 和 匿名函数一样，持有it。
        // 匿名函数的最后一行 作为返回值，返回类型根据最后一行的变化而变化，而apply 始终返回元素本身
    }

    println("result2 : $result2")
    val result3: Boolean = listOf(6, 5, 2, 3, 5, 7).let {
        //it == list集合
        it.first() + it.first()
        //匿名函数的最后一行 作为返回值，而apply 始终返回元素本身.
        true
    }
    println("result3 : $result3")

    // 普通方式对null处理，并返回
    println(getMethod("Derry"))
    println(getMethod3("Derry"))
    println(getMethod3(null))

}

//普通方式，对值判断null，并返回
fun getMethod(value: String?): String {
    return if (value == null) "你传递的内容是null" else "欢迎回来$value"
}

//普通方式，对值判断null，并返回 简化版本 类型自动推断
fun getMethod2(value: String?) = if (value == null) "你传递的内容是null" else "欢迎回来$value"

//let方式对值判null并返回;let + null 合并操作符
fun getMethod3(value: String?): String {
    return value?.let {
        //如果value为null则不执行
        "欢迎回来${it}非常欢迎"
    } ?: "你穿的内容是null"
}

//简化版本
fun getMethod4(value: String?) = value?.let {
    //如果value为null则不执行
    "欢迎回来${it}非常欢迎"
} ?: "你穿的内容是null"
