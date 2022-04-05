/**
 * Description:
 * Created by small small su
 * Date: 2022/3/28
 * Email: surao@foryou56.com
 */

fun main() {

// TODO: 2022/3/28 函数引用   :: 的作用是 把 普通函数 变成 函数对象 来使用
    loginApi("Derry", "1234", ::methodResResult)
    val obj1 = ::methodResResult
    loginApi("Derry", "1234", obj1)

    val methodAction4: (String, Int) -> Unit = { s: String, i: Int ->
        //一个参数的自动增加it
        "ss"
    }
    loginApi("Derry", "1234", methodAction4)


    // TODO: 2022/3/28 函数作为 函数的返回类型
    show("学习kotlin")
    val method_show = show2("学习kotlin")
    //  method_show = "匿名函数"
    println(method_show)
    println(method_show("ss", 22))


// TODO: 2022/3/28  kotlin语言的匿名函数 与 具名函数
    showPersonInfo("lisi", 99, '男', "学习kotlin") {
        println("reslut:$it")
    }

    showPersonInfo("wangwu", 99, '女', "学习c", ::showResultImpl)

    // TODO: 2022/3/28 可空性的特点
    var name: String = "Derry"
    //不能是非空类型String的值
    //第一种情况，默认不可空类型，不能随意给null name = null
    //第二种情况，声明时指定为可空类型 加？
    var name2: String? = "张三"
    name2 = null

    // TODO: 2022/3/28 ？操作符 避免空指针类型
//    name2.capitalize()  报错
    name2?.capitalize() //如果name是null了，？后这一段代码不执行，不会引发空指针异常
    name2 = "" //而不是？
    // TODO: 2022/3/28 let函数 空安全的调用
    // 如果name2为空，则 ？后的不执行
    val r = name2?.let {
        //如果 能够执行到这里面来 name2 一定不为null
        //it == name本身
        if (it.isBlank()) { // ""会触发
            //如果 name2是空值
            "Defalut"
        } else {
            it
        }
    }
    println(r)

    // TODO: 2022/3/28 非空断言操作符 断言操作对可空类型的处理 !!
    var name3: String? = null
//    name3.capitalize()
    name3?.capitalize() //方式一
//    val r3 = name3!!.capitalize() //!! 断言不管name是不是null 都执行，跟java一样
//    println("r3：$r3")
    //结论 如果保证name3百分百有值的 才能使用断言，否则有java空指针风险

    // TODO: 2022/3/28 if对可空类型的补救措施
    if (name3 != null) {
        val r3 = name3!!.capitalize()
        println(r3)
    } else {
        println("name is null")
    }

    // TODO: 2022/3/28 kotlin 空合并操作符 ?:
    var info: String? = "lixiaol"
    info = null
    //如果info为null，则会执行 ?: 后面的区域
    println(info ?: "原来你是null")

    // TODO: 2022/3/28 let + ?: 操作符
    println(info?.let {
        "[$it]"
    }?:"line 88 ：原来你是null")


}


// TODO: 2022/3/28 内联
//只要函数中有lambda 就要声明成内联
//如果此函数不实用内联，在调用端，会生成多个对象来完成lambda的调用，性能有所损耗
//声明成内联，相当于c++的宏定义，宏替换，减少性能损耗，会把代码替换到调用处，调用处没有任何对象开辟的损耗
//如果函数参数 有lambda 尽量使用内联关键字，这样内部会做优化，减少函数开辟和对象开辟的损耗
inline fun logisnApi(userName: String, userPwd: String, responseResult: (String, Int) -> Unit) {
    if (userName == null || userPwd == null) {
        TODO("用户名或密码为kong") //出现问题 终止程序

    }
    if (userName.length > 3 && userPwd.length > 3) {
    } else {
        TODO("用户名密码不合格") //出现问题 终止程序
    }
}

const val USER_NAME_1 = "Derrys"
const val USER_PWD_2 = "1234"

// TODO: 2022/3/28 函数引用学习
inline fun login(name: String, pwd: String, responseResult: (String, Int) -> Unit) {
    if (USER_NAME_1 == name && USER_PWD_2 == pwd) {

        responseResult("success", 200)
    } else {
        responseResult("fail", 444)
    }
}

fun methodResResult(msg: String, code: Int) {
    println("result  msg:$msg, code:$code")
}

// TODO: 2022/3/28 函数作为 函数的返回类型
fun show(info: String): String {
    println("我是show函数 info$info")
    return ""
}

fun show2(info: String): (String, Int) -> String {
    println("我是show函数 info$info")
    return { name: String, age: Int ->
        "我就是匿名函数 name:$name,age:$age "
    }
}

// TODO: 2022/3/28  kotlin语言的匿名函数 与 具名函数  java中需要使用接口
inline fun showPersonInfo(name: String, age: Int, sex: Char, study: String, showResult: (String) -> Unit) {
    val str = "name:$name,age:$age,sex:$sex,study:$study"
    showResult(str)
}

fun showResultImpl(result: String) {
    println("reslut:$result")
}

// TODO: 2022/3/28 可空性的特点

