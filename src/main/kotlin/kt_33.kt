/**
 * Description:
 * Created by small small su
 * Date: 2022/4/7
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/7 注解 @JvmName 只能写在第一行，写在包名 package 之前
@file:JvmName("Student")

//在编译器环节 把生成的java类名改成 Student,自己写的java类用起来方便，用于java与kt交互

class PersonT {
    //在java类中 只能通过get获取，不能通过person.names2调用
    val names = listOf("张三", "李四")

    @JvmField   //在java类中 直接用person.names2调用
    val names2 = listOf("张三", "李四")

}

@JvmOverloads //编译器生成一个java中的重载函数
fun show(name: String, age: Int = 20, sex: Char = 'M') {

}

class MyObject {

    companion object {
        //java中调用时, MyObject.Companion.TARGET，在java中会创建这个 static Companion类
        val TARGET = "黄石公园"

        @JvmStatic   // java中会把 name 这个类 放到Companion类外面，所以可以 MyObject.name
        val name = "sss"

        fun showAction(name: String) = println("$name 要去 $TARGET 玩")
    }
}

fun main() {
    // java中 无法享用kt中的默认参数,除非在方法外 JvmOverloads注解
    show("张三")

    MyObject.showAction()
}