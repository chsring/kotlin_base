/**
 * Description:
 * Created by small small su
 * Date: 2022/4/2
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/2 主构造函数的学习
//主构造函数，规范来说，都是增加_xxx的方式，临时的输入类型，不能直接用，需要接受下来成为变量才能用
class KtBase72(_name: String, _sex: Char, _age: Int, _info: String) {
    var name = _name
        get() = field //        private get() = field 个体不允许私有化
        private set(value) {
            field = value
        }
    val sex = _sex
        get() = field
//    set(value) {} sex只读的 不能被set

    val age = _age
        get() = if (field < 0) -1 else field + 1

    val info = _info
        get() = "[$field]"

    fun show() {
        println("name:$name")
        println("sex:$sex")
        println("age:$age")
        println("info:$info")
    }

}

// TODO: 2022/4/2 次构造函数
class KtBase73(var name: String, val sex: Char, val age: Int, var info: String) {

}

// TODO: 2022/4/2 次构造 与 主构造配合
class KtBase74(name: String) {
    //次构造函数必须调用 主构造,若有多个次构造，则由主构造统一管理
    constructor(name: String, sex: Char) : this(name) {
        println("name :$name , sex :$sex")
    }

    constructor(name: String, sex: Char, age: Int) : this(name) {
        println("name :$name , sex :$sex , age :$age")
    }

    constructor(name: String, sex: Char, age: Int, info: String) : this(name) {
        println("name :$name , sex :$sex , age :$age , info :$info")
    }


}

// TODO: 2022/4/2 构造函数中默认参数
class KtBase75(name: String = "李元霸") {
    //次构造函数必须调用 主构造,若有多个次构造，则由主构造统一管理
    constructor(name: String = "李连杰", sex: Char = '男') : this(name) {
        println("name :$name , sex :$sex")
    }

    constructor(name: String = "李小龙", sex: Char = '男', age: Int = 32) : this(name) {
        println("name :$name , sex :$sex , age :$age")
    }

    constructor(name: String, sex: Char, age: Int, info: String) : this(name) {
        println("name :$name , sex :$sex , age :$age , info :$info")
    }

}

fun main() {
    val p = KtBase72(_name = "Zhangsan", _info = "学习kt", _age = 10, _sex = '男')
//    p._name = "AAA" 私有化了，不能调用
    println(p.name)
    p.show()

    KtBase73(name = "Zhangsan", info = "学习kt", age = 10, sex = '男')

    val p1 = KtBase74("李元霸")

    KtBase74("张三", '男')
    KtBase74("张三", '男', 10)
    KtBase74("张三", '男', 10, "备注")

    val p2 = KtBase75("李元霸")

    KtBase75() //到底调用哪一个 ？ 优先调用主构造函数



}