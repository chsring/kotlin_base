/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/3 代数数据类型
enum class Exam {
    Fraction1, //分数差
    Fraction2, //分数及格
    Fraction3, //分数良好
    Fraction4; //分数优秀

    //需求 得到优秀学生的名字
    var studentName: String? = null
    //我们用枚举类 做到次需求 就很麻烦了，很难
}

class Teachaer(private val exam: Exam) {
    fun show(): String =
        when (exam) {
            Exam.Fraction1 -> "该学生分数差"
            Exam.Fraction2 -> "分数及格"
            Exam.Fraction3 -> "分数良好"
            Exam.Fraction4 -> "分数优秀"
            //else -> 由于 show函数 使用的是 枚举类型来做判断处理的，属于代数数据类型，不需要写else
            //when 表达式 非常明确了 ，就只有4中类型，不会出现其他
        }
}

// TODO: 2022/4/3 密封类🐝  我们的成员 必须有类型了 并且继承本类
sealed class Exams {
    //object 只会实例化一次,第一个到第三个，不需要任何成员，所以一般写成obj
    object Fraction1 : Exams()   //分数差
    object Fraction2 : Exams()   //分数及格
    object Fraction3 : Exams()   //分数良好

    //假设 Fraction4 写成obj ，每当传入一个名字 都会需要生成两个不同的对象
    class Fraction4(val studentName: String) : Exams(); //分数优秀

    //需求 得到优秀学生的名字

}

class SealedTeachaer(private val exam: Exams) {
    fun show(): String =
        when (exam) {
            is Exams.Fraction1 -> "该学生分数差"
            is Exams.Fraction2 -> "分数及格"
            is Exams.Fraction3 -> "分数良好"
            is Exams.Fraction4 -> "分数优秀:该学生的名字是:${(this.exam as Exams.Fraction4).studentName}"
            //else -> 由于 show函数 使用的是 枚举类型来做判断处理的，属于代数数据类型，不需要写else
            //when 表达式 非常明确了 ，就只有4中类型，不会出现其他
        }
}

// TODO: 2022/4/3 data class 的使用场景：只做数据载入
//条件一： 用于服务器请求回来 的相应的javaBean ，如 LoginResponseBean
//条件二： 数据类 至少 必须有 至少 一个参数 var 或 val 的主构造函数，
//条件三： 不能用 abstract,sealed ,open,inner 等等修饰
//条件四： 需要比较 copy toString 解构 等等丰富的功能时

fun main() {
    println(Teachaer(Exam.Fraction4).show())

    println(SealedTeachaer(Exams.Fraction1).show())
    println(SealedTeachaer(Exams.Fraction4("里斯")).show())

    // obj 是单例 只会实例化一次
    println(Exams.Fraction1 === Exams.Fraction1)

    //class 有两个不同的对象 所以是false
    println(Exams.Fraction4("里斯") === Exams.Fraction4("里斯"))

}
