import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/3 继承重载的open关键字

//所有的类 默认是final修饰的，不能被继承，和java相反
// open 移除final修饰
open class Person(val name: String) {
    private fun showName() = "父类 的姓名是 [$name]"

    //所有的函数 默认是 final 修饰的 不能被重写
    open fun myPrintln() = println(showName())

    fun myPrintPerson() = println(showName())
}

class Student(val subName: String) : Person(subName) {
    override fun myPrintln() = println(showName())

    private fun showName() = "子类的姓名是[$subName]"

    fun myPrintlnStudent() = println(showName())
}

fun main() {
    val person: Person = Student("张三")
    person.myPrintln()

    val p: Person = Student("王武")
    p.myPrintln()

    println("p is Person:${p is Person}")
    println("p is Student:${p is Student}")
    println("p is File:${p is File}")

    // TODO: 2022/4/3  类型转换
    if (p is Student) {
        (p as Student).myPrintln()
    }

    if (p is Person) {
        (p as Person).myPrintln()
    }

    // TODO: 2022/4/3  智能类型转换学习
    val p2: Person = Student("里斯")
    p2.myPrintPerson()
    (p2 as Student).myPrintlnStudent()
    p2.myPrintlnStudent()  //一次 as 转换后 智能类型转换  就可以直接调用了

}