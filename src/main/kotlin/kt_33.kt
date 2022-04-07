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


fun main() {

}