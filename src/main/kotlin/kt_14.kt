/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/3 内部类
//内部类 能访问外部类 ; 外部类能访问内部类
class Body(_bodyInfo: String) {
    val bodyInfo = _bodyInfo

    fun show() {
        //内部类 能访问外部类 ; 外部类能访问内部类
        Heart().run()
    }

    //默认情况下，内部得类不能访问外部来，要增加修饰符 inner
    inner class Heart {
        //内部类 能访问外部类 ; 外部类能访问内部类
        fun run() = println("心脏信息：$bodyInfo")
    }

    inner class Hand {
        inner class LeftHand {

        }
    }

}

// TODO: 2022/4/3 嵌套类: 外部类可以访问 里面的嵌套类 ; 里面的嵌套类不能访问外部类
//默认请款下 就是嵌套类 关系
class Outer {
    val info: String = "OK"

    fun show() {
        Nested().output()
    }

    class Nested {
        //        fun output() = println(info) //info 是拿不到的
        fun output() = println()
    }
}

// TODO: 2022/4/3 数据类
//普通类 服务器请求的 javaBean: 默认提供set  get函数
class ResResultBean(var msg: String, var code: Int, var data: String) {}

//数据类 一般用于javaBaean的形式： 除了set，get，还提供了 解构函数，copy操作，toString，hashCode，equals
data class ResResultDataBean(var msg: String, var code: Int, var data: String) {}

// TODO: 2022/4/3 data calss 中 的copy
data class KtBase92(var name: String, var age: Int) {
    var coreInfo: String = ""

    init {
        println("主构造被调用")
    }

    constructor(name: String) : this(name, 10) {
        println("次构造被调用")
        coreInfo = "核心内容信息"
    }

    //默认的toString 只管主构造的参数，不管次构造和 自己写的toString，所以 会丢掉coreInfo
    override fun toString(): String {
        return "toString name:$name, age:$age, coreInfo:$coreInfo"
    }
}


fun main() {
    //普通类，默认继承Any ，调用Any的 toString,不同平台对 toString有不同的实现
    println(ResResultBean("login success", 200, "登录成功"))

    //数据类：Any， 但是 ResResultDataBean 会额外生成toString，默认重写了Any的toString
    println(ResResultDataBean("login success", 200, "登录成功"))

    //前面我们学习了 值比较  == 和 引用比较===
    println( //调用父类的 equals
        " == ：${
            ResResultBean("login success", 200, "登录成功")
                    == ResResultBean("login success", 200, "登录成功")
        }"
    )

    println(
        " == ：${
            ResResultDataBean("login success", 200, "登录成功")
                    == ResResultDataBean("login success", 200, "登录成功")
        }"
    )

    println(
        " === ：${
            ResResultBean("login success", 200, "登录成功")
                    === ResResultBean("login success", 200, "登录成功")
        }"
    )

    println(
        " === ：${
            ResResultDataBean("login success", 200, "登录成功")
                    === ResResultDataBean("login success", 200, "登录成功")
        }"
    )

    val p1 = KtBase92("里斯") //调用次构造 初始化

    println(p1)
    val p2 = p1.copy("李连杰", 78)
    println(p2)
    //copy 也好 toString也好，hashCode，equals 等 只管主构造的参数。在使用copy的时候 必须考虑次构造的感受
    //由于内部代码只处理主构造函数的参数，所以 次构造函数的参数会丢失，除非重写


}