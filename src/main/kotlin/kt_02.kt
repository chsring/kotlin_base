/**
 * Description:
 * Created by small small su
 * Date: 2022/3/17
 * Email: surao@foryou56.com
 */

// TODO: 2022/3/17 匿名函数
fun main() {
    val len = "Derry".count()
    val len2 = "苏饶Dr".count {
        //it 等价于 这个字符串的每一个字符
        it == 'r'
    }
    println(len)
    println(len2)


// TODO: 2022/3/17 隐式返回
    //第一步：写函数输入输出的声明
    val methodAction: () -> String
    //第二步 实现 相当于 下面的 methodAction（）
    methodAction = {
        "ss"  //不用return,最后一行就是返回值
        "sss"
        val inputValue = 999
        "$inputValue Derr"
    }

    /**
     * fun methodAction():String{
     * return "ss"
     * }
     */
    println(methodAction())
//    println(methodAction)

    // TODO: 2022/3/17 函数参数

    val methodAction2: (Int, Int, Int) -> String = { nu1, nu2, nu3 ->
        val inputValue = 999
        "$inputValue Derr,$nu1"
    }
    /**
     * fun methodAction2(nu1:Int , nu2:Int ,nu3 Int ): String{
     * }
     */
    println(methodAction2(1, 2, 3))

    // TODO: 2022/3/17 匿名函数之上讲解it 关键字

    val methodAction3: (Int, Int, Int) -> String = { nu1, nu2, nu3 ->
        val number = 23333
        var str = "$number Derry, nu1:$nu1,nu2:$nu2,nu3:$nu3"
        println(str)
        str
    }
    methodAction3(1, 2, 3)
    methodAction3.invoke(1, 2, 3)

    val methodAction4: (String) -> String = {
        //一个参数的自动增加it
        "$it"
    }
    /**
     * fun methodAction4( it : String ) : String {
     *
     * }
     */

    println(methodAction4.invoke("sss"))

    // TODO: 2022/3/22 匿名函数的类型推断
    //让类型 自动推断为String
    //方法名 ： 必须制定 参数类型 和返回类型
    //方法名 = 类型推断返回类型
    val method1 = { v1: Double, v2: Float, v3: Int ->
        "v1：$v1" //自动推为String
    }

    println(method1(444.4, 333f, 3333))

    // TODO: 2022/3/22 lamda 等价于 匿名函数
    val addResultMethod = { number: Int, number2: Int ->
        "两数相加的结果:${number + number2}"

    }

    //匿名函数 入参 int  返回Any，匿名函数 属于lambda
    //lambda表达式 参数Int lambda的结果是Any类型
    val weekResultMethod = { number: Int ->
        when (number) {
            1 -> "星期一"   //string 类型
            else -> -1  //int 所以崩溃了
        }
        //实际上返回Any
    }
    println("星期：" + weekResultMethod(2))

    // TODO: 2022/3/28 函数中定义参数  java中用接口来做 kotlin 中 参数可以是函数
    loginApi("Derry", "123456", fun(msg: String, code: Int) {
        println("登录情况：msg:$msg , code$code")
    })

    loginApi("Derry2", "123456",{ msg, code ->
        println("登录情况：msg:$msg , code$code")
    })

    loginApi("Derry2", "123456") { msg, code ->
        println("登录情况：msg:$msg , code$code")
    }
}

// TODO: 2022/3/28 函数中定义参数  java中用接口来做 kotlin 中 参数可以是函数
const val USER_NAME = "Derry"
const val USER_PWD = "123456"

//模仿前端
fun loginApi(userName: String, userPwd: String, responseResult: (String, Int) -> Unit) {
    if (userName == null || userPwd == null) {
        TODO("用户名或密码为kong") //出现问题 终止程序

    }
    if (userName.length > 3 && userPwd.length > 3) {
        if (webLoginApi(userName, userPwd)) {
            //登录成功
            responseResult("login success", 200)
        } else {
            //登录失败
            responseResult("login fail", 300)
        }
    } else {
        TODO("用户名密码不合格") //出现问题 终止程序
    }
}

private fun webLoginApi(name: String, pwd: String): Boolean {
    //kotlin中的if是表达式
    return if (name == USER_NAME && pwd == USER_PWD) true else false
}



