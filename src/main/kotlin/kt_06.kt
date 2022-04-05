import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/3/31
 * Email: surao@foryou56.com
 */
/**
 * 内置函数的总结：
 * todo apply
 *      1. 返回info本身 :谁
 *      2. 匿名函数里面持有的是this == str本身：this
 * todo let
 *      1. let函数返回类型 是根据最后一行变化而变化：最后
 *      2. let函数 里面持有的是 it== 集合本身：it
 *
 * todo run
 *      1. run函数返回类型 是根据最后一行变化而变化 ：最后
 *      2. 匿名函数里面持有的是this == str本身： this
 *
 *  todo with 和run 一模一样只有使用不同，单无str.with，必须传给他 with（str）
 *      1. with函数返回类型 是根据最后一行变化而变化 ：最后
 *      2. 匿名函数里面持有的是this == str本身：this
 *
 *  todo also内置函数 str.also
 *      1.also 用于str本身 用于str本身，谁.also 就返回谁，不变：谁
 *      2.持有it == str本身：it
 *
 *  todo takeIf 内置函数
 *      1.如果 true，返回name本身，false 返回null
 *      2.it
 *
 *  todo takeUnless 和 takeIf 功能相反
 *      1.如果 true，返回null，false 返回name本身
 *      2.it
 *      注：为什么有 takeUnless ？一个takeIf不久够了么
 */

// TODO: 2022/3/31 run内置函数
//1. run函数的特点 字符串延时
//2. 具名函数判断长度 isLong
//3. 具名函数检测合格 showText
//4. 具名函数增加一个括号 mapText
//5. 具名函数输出内容

fun main() {

    val str = "Derry is OK"
    val r1: Boolean = str.run {
        true
    }
    val r2: Float = str.run {
        true
        23.3f
    }
    println(r1)

    //下面是具名函数 配合 run 函数

    //这个是匿名配合run
    str.run {
//        this == str

    }

    //这个是数据 具名函数
//    str.run(具名函数) 类似于rxjava
    val r3: Boolean = str.run(::isLong)
    val r4: String = str.run(::isLong).run(::showText)
    val r5: String = str.run(::isLong) //this == boolean 类型
        .run(::showText)//this == string类型
        .run(::mapText)

    println(r5)
    str.run(::isLong)
        .run(::showText)
        .run(::mapText)
        .run(::println)

    //具名+匿名
    str.run(::isLong).run(::showText).run(::mapText).run {
        println(this)
    }

    str.let(::isLong)
        .let(::showText)
        .let(::mapText)
        .let(::println)

    str.apply(::isLong)
//        .apply(::showText)  报错了 因为 apply 返回info本身
        .apply(::mapText)
        .apply(::println)

    // TODO: 2022/3/31 with
    val str2 = "李元霸"
    with(str2, ::println)
    with(str2, ::isLong)
    with(true, ::showText)
    with(str2, ::mapText)
    val r6 = with(str2, ::getStrLen)
    val r7 = with(r6, ::getLenInfo)
    val r8 = with(r7, ::mapText)
    with(r8, ::println)
    //不停的with包裹
    with(
        with(str) {
            getStrLen(this)
        }
    ) {

    }

    // TODO: 2022/3/31 also 谁.also 就永远返回谁 跟apply一样
    val r9: String = str.also {
        true
        333
        333.4
        'C'
    }
    str.also {
        println("str的原始数据是:$it")
    }.also {
        println("小写：:${it.toLowerCase()}")
    }.also {
        println("end")
    }

    val file = File("")
    file.also {

    }.also {
    }.also {
    }.also {
        //  假设做了很多事情 最后仍然返回 file
    }

    println("takeIf test : ${checkPermission("Derry", "1")}")
    println("takeIf test : ${checkPermission("Root", "11")}")

    println("takeIf test : ${checkPermission2("Root", "111")}")

    // TODO: 2022/3/31 takeUnless
    var manager = Manager()
//    "Derry".takeIf { it == Derry }
//    "Derry".takeUnless { it == Derry }
    val r10 = manager.getInfoValue().takeUnless {
        it.isNullOrBlank()
    } ?: "未经过任何初始化"
    println(r10)
    //小结：takeUnless + it.isNullOrBlank（） 一起使用 可以验证字符串有没有初始化

}

//具名函数判断长度 isLong
fun isLong(str: String) = str.length > 5

//3. 具名函数检测合格 showText
fun showText(isLong: Boolean) = if (isLong) "你的字符串合格" else "你的字符串不合格"

//4. 具名函数增加一个括号 mapText
fun mapText(getShow: String)/* ：String*/ = "【$getShow】"
fun getStrLen(str: String) = str.length
fun getLenInfo(len: Int) = "字符串长度是：$len"

public fun checkPermission(name: String, pwd: String): String? {
    return name.takeIf {
        permissionSystem(it, pwd) //如果 true，返回name本身，false 返回null
    }
}

//大部分情况下 配合使用 takeIf + 空合并
public fun checkPermission2(name: String, pwd: String): String? {
    return name.takeIf {
        permissionSystem(it, pwd) //如果 true，返回name本身，false 返回null
    } ?: "你的权限不够"
}

private fun permissionSystem(username: String, userpwd: String): Boolean {
    return if (username == "Root" && userpwd == "11") true else false
}

class Manager {
    private var infoValue: String? = null
    fun getInfoValue() = infoValue
    fun setInfoValue(infoValue: String?) {
        this.infoValue = infoValue
    }
}