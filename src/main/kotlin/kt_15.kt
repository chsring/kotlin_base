/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/3 解构声明学习
class Student1(var name: String, var age: Int, var sex: Char) {
    //注意 顺序必须是 component1 ，component2，component3
    //data class 自动生成 解构
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = sex
}

data class Student2(var name: String, var age: Int, var sex: Char)

// TODO: 2022/4/3  运算符重载
class AddClass(number1: Int, number2: Int)

//写一个数据类 就是为了toString 打印方便
data class AddClass2(var number1: Int, var number2: Int) {
    //运算符重载
    operator fun plus(p1: AddClass2): Int {
        return number1 + p1.number1 + number2 + p1.number2
    }

    //查看整个KT可以用的运算符重载方式 operator fun AddClass2.
}

// TODO: 2022/4/3 枚举  kt想表达 枚举也是一个class 就是为了枚举又更丰富的功能
enum class Week {
    星期一,
    星期二,
    星期三,
    星期四,
    星期五,
    星期六,
    星期日;
}

// TODO: 2022/4/3 枚举类定义函数学习
data class LimbsInfo(var info: String, var len: Int) {
    fun show() {
        println("${info}的长度是：$len")
    }
}

enum class Limbs(private var limbsInfo: LimbsInfo) {
    LEFT_HAND(LimbsInfo("左手", 88)),
    RIGHT_HAND(LimbsInfo("右手", 88)),
    LEFT_FOOT(LimbsInfo("左脚", 140)),
    RIGHT_FOOT(LimbsInfo("右脚", 140));  //最后 用 ； 结束枚举值
    //这个时候 在定义单调的枚举值就报错了； 所有枚举值必须保持一致
    //枚举的主构造函数 必须跟枚举值里面的参数 保持一致

    fun show() = "四肢是:${limbsInfo.info}，长度是:${limbsInfo.len}"

    fun updateData(limbsInfo: LimbsInfo) {
        this.limbsInfo.info = limbsInfo.info
        this.limbsInfo.len = limbsInfo.len
        println("更新后的数据是:${this.limbsInfo}") // data calss 重写了 toString
    }

}


fun main() {
    val (name, age, sex) = Student1("里斯", 10, '男')
    println("普通类 解构后 : name:$name , age:$age, sex:$sex")

    val (name1, age1, sex1) = Student2("里斯", 10, '男')
    println("数据类 解构后 : name:$name1 , age:$age1, sex:$sex1")

    val (_, age2, _) = Student2("里斯", 10, '男')
    println("数据类 解构后 : name:$ , age:$age2, sex:$")

    // TODO: 2022/4/3 运算符重载
    //kt 中plus
    println("+: ${AddClass2(1, 1) + AddClass2(2, 2)}")

    //枚举的值 等价于 枚举本身
    println(Week.星期三)

    // TODO: 2022/4/3 枚举
//    println(LimbsInfo().show()) 一般不会这么用
    println(Limbs.LEFT_FOOT.show())
    println(Limbs.RIGHT_HAND.show())

    println(Limbs.LEFT_HAND.updateData(LimbsInfo("右手2",99)))
}