/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/4  范型变换 第106集
class ktBase105<T>(val isMap: Boolean = false, val input: T) {
    //模仿Rxjava ，R是变换后的类型 ，T是要变换的输入类型
    //要求map返回的类型是 R？
    inline fun <R> map(mapAction: (T) -> R): R?/* 有可能返回R，有可能null*/ = mapAction(input).takeIf {
        isMap
    }
}

//模仿 Rxjava 变换操作
fun <I, O> map(isMap: Boolean = true, inputValue: I, mapAction: (I) -> O) {
    if (isMap) mapAction(inputValue) else null
}

data class Person3(val name: String, val age: Int)
data class Students(val name: String, val age: Int)

// TODO: 2022/4/4 范型约束
open class MyAnyClass(name: String)
open class PersonClass(name: String) : MyAnyClass(name = name)
class StudentClass(name: String) : PersonClass(name = name)
class TeacherClass(name: String) : PersonClass(name = name)
class DogClass(name: String)

//PersonClass 与PersonClass 的子类都可以使用范型，其他类 不可使用
class KtBase106<T : PersonClass>(private val inputTypeValue: T, private val isR: Boolean = true) {
    //万能对象返回器
    fun getObj(): T? = inputTypeValue.takeIf { isR }
}

fun main() {
    ktBase105(isMap = true, input = 543).map { it }
    val p1 = ktBase105(true, 543)
    val r = p1.map {
        "我的it是：$it"
        // lambda 最后一行是返回类型
    }

    //String 和 String? 不是同一个类型
    println(r is String)
    println(r is String?)

    val p2 = ktBase105(true, Person3("里斯", 99))
    val p3 = p2.map {
        Students(it.name, it.age)
    }
    println(p3)

    println(map(inputValue = 123) {
        true
    })

    // TODO: 2022/4/4 范型约束
    val pp1 = MyAnyClass("Derry1")
    val pp2 = PersonClass("Derry2")
    val pp3 = StudentClass("Derry3")
    val pp4 = TeacherClass("Derry4")
    val pp5 = DogClass("Derry5")

//    val rr1: MyAnyClass? = KtBase106(pp1).getObj()
//    println(rr1)

    val rr2: MyAnyClass? = KtBase106(pp2).getObj()
    println(rr2)

    val rr3: MyAnyClass? = KtBase106(pp3).getObj()
    println(rr3)

    val rr4: MyAnyClass? = KtBase106(pp4).getObj()
    println(rr4)

//    val rr5 = KtBase106(pp5).getObj()
//    println(rr5)
}