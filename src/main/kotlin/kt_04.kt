import kotlin.math.roundToInt

/**
 * Description:
 * Created by small small su
 * Date: 2022/3/28
 * Email: surao@foryou56.com
 */
fun main() {
    // TODO: 2022/3/28  异常处理 与自定义异常
    try {
        var info: String? = null
        checkExcception(info)
        println(info!!.length)
    } catch (e: Exception) {
        println("啊呀:$e")
    }

    // TODO: 2022/3/28 kotlin的先决条件函数 checkNotNull   requireNotNull 检测空异常 ；require检测是否为ture false
    var value1: String? = null
//    checkNotNull(value1)
//    requireNotNull(value1)
    //假设 我写一个框架给别人用，需要检测别人传入的变量是否为空
    var value2: Boolean = false
//    require(value2)

    // TODO: 2022/3/29 substring
    val info = "Derry is succei sfre"
    val indexOf = info.indexOf("i")
    println(info.substring(0, indexOf))
    println(info.substring(0 until indexOf))

    // TODO: 2022/3/29 split 分割方法，list为 List<String>
    val list = info.split(" ")
    println(list)
    //  c++中解构，kt也有
    val (v1, v2, v3, v4) = list
    println("v1:$v1,v2:$v2,v3:$v3,v4:$v4")

    // TODO: 2022/3/29 用replace完成加密解密密码
    val sourcePwd = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //Regex正则表达式 ， 就是把字符替换成数字，打乱了就属于加密
    val newPwd = sourcePwd.replace(Regex("[AKMNO]")) {
//        it.value //没有做任何操作
        //如果传进来的是A K M N O 这几个字符
        when (it.value) {
            "A" -> "9"
            "K" -> "3"
            "M" -> "9"
            "N" -> "3"
            "O" -> "3"
            else -> it.value
        }
    }
    println("加密后：$newPwd")

    // TODO: 2022/3/29  === 与 ==
    // === 引用的比较
    // == 相当于equls

    val name1 = "Derry"
    val name2 = "Derry"
    println("equal :${name1.equals(name2)}")   //true
    println(" 1 == 2: ${name1 == name2}")         //true
    println(" 1 === 2 : ${name1 === name2}")        //true   Derry存在常量池中，name1 与 name2 都指向Derry

    val name4 = "derry".capitalize() //修改成大写
    println(" 1 == 4: ${name1 == name4}")
    println(" 1 === 4: ${name1 === name4}")

    // TODO: 2022/3/29 字符串遍历操作
    val str = "ABCDEFG"
    str.forEach {
        // it == str的 每一个字符 ABCDEFG
        println("所有的字符是:$it")
    }
    str.forEach { c -> //覆盖it
        println("所有的字符是:$c")
    }

    // TODO: 2022/3/29 类型转化桉
    val number: Int = "666".toInt()
//    val number2: Int = "666.6".toInt() //会崩溃
    val number2: Int? = "666.6".toIntOrNull() //会崩溃 如果转不成功则返回空，所以 Int后加？转换成可空的
    println(number2 ?: "原来你是null")
    // 以后有字符穿相关转换 尽量用toIntOrNull
    println(65.464444.toInt())
    println(65.8344444.roundToInt()) //roundToInt保证double 转 int 有四舍五入效果

    // TODO: 2022/3/29 保留小数点 
    val r: String = "%.3f".format(65.8344444)
    println(r)
}

fun checkExcception(info: String?) {
    info ?: throw CustomException()
}

class CustomException : IllegalArgumentException("你的代码太不严谨")