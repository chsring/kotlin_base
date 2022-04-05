/**
 * Description:
 * Created by small small su
 * Date: 2022/4/2
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/2 代码块的学习
// name ,age ,sex 的主构造函数
// init代码块学习require
// 临时类型只有在 init代码块 才能调用
//userName: String, userage: Int, usersex: Char 临时类型，必须二次转换`
class KtBase76(userName: String, userage: Int, usersex: Char) {

    //这个不是java的static ,而是 init初始化。相当于java的构造函数的代码块
    init {
        println("主构造函数被调用了 $userName $userage")
        //可以对临时参数进行校验  require 如果第一个参数为false ，那么会调用第二个参数的lambda
        require(userName.isNullOrBlank()) {
            "你的userName 空空如也"
        }

        require(userage > 0) {
            "你的年龄不符合"
        }
    }

    constructor(userName: String) : this(userName, 87, 'M') {
        println("次构造被调用了")
    }

}

// TODO: 2022/4/2 构造函数 初始化顺序学习
// 第一步： val sex :Char
class KtBase77(_name: String, val sex: Char) {
    //第二步：生成val mName
    val mName = _name

    init {
        //第三步：生成nameValue
        val nameValue: String = _name
        println("init 代码块打印")
    }

    constructor(name: String, sex: Char, age: Int) : this(name, sex) {
        //第四步
        println("次构造 三个参数 初始化 ")
    }


    //纠正网上错误：类成员先初始生成，再init代码初始生成，这是错误的
    //init 代码块 和 类成员 是同时的，只不过 拟写再init代码块前面

}

// TODO: 2022/4/2 延时初始化 lateinit 在使用时手动加载的方式
class KtBase78 {
    //不能用val ，因为后面无法再修改了，所以 必须用var
    lateinit var responseResultInfo: String;  //我等会再来初始化你

    //模拟服务器请求
    fun request() {
        responseResultInfo = "服务器加载成功"
    }

    fun showResponse() {
//        if(responseResultInfo ==null) //这句话就崩溃了,由于没有初始化，所以只要用到就崩溃
        if (::responseResultInfo.isInitialized)
            println("responseResultInfo:$responseResultInfo")
        else
            println("你都没有初始化，是不是忘记加载了")
    }


}

class KtBase79 {

    val dataBase1: String = readSQL()

    // TODO: 2022/4/3 by lazy 自动惰性加载,用的时候在加载
    val dataBase2 by lazy {
        readSQL()
    }

    private fun readSQL(): String {
        println("开始...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("加载读取数据库数据中...")
        println("结束...")
        return "database data load success ok"
    }
}

fun main() {
//    KtBase76("lisi", 88, 'M')
//    KtBase76("lisi")
//    KtBase76("")
//    KtBase76("", -1, 'M')

    KtBase77("李元霸", '男', 88)

    KtBase77("李元霸", '男')

    val p = KtBase78()
    //在使用 lateinit变量之前，必须初始化，用到它才加载
    p.request()
    p.showResponse()

    val p1 = KtBase79()
    Thread.sleep(5000)
    println("即将开始使用dataBase1")
    println("最终显示：${p1.dataBase1}")

    println("即将开始使用dataBase2")
    println("最终显示：${p1.dataBase2}")

}