package rxkotlin

/**
 * Description:
 * Created by small small su
 * Date: 2022/4/7
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/7 手写Rxjava

//中转站，保存我的记录,主构造接受传进来的信息,就是create最后一行的返回
class RxJavaCoreObject<T>(val value: T) {
    //value = create操作符最后一行的返回值
}

inline fun <O> create(action: () -> O): RxJavaCoreObject<O> {
    //create的最后一行 给了中转站
    return RxJavaCoreObject<O>(action())
}

//中转站函数扩展 ，保存我们的记录。 map 的输入元 就是create的输出元，map的输出元 就是最后一行
inline fun <I, O> RxJavaCoreObject<I>.map(lambda: (I) -> O): RxJavaCoreObject<O>/* 链式*/ {
    return RxJavaCoreObject(lambda(value))
}

//中转站函数扩展 消费 observer只有输出，没有输出
inline fun <I> RxJavaCoreObject<I>.oberver(action: (I) -> Unit) {
    action(value)
}

fun main() {
    //create 输入元没有任何参数给你，你是输出就行
    create {
        "AAA"
    }.map {
        "[$it]"
    }.map {
        "$it sss"
    }.oberver {
        //只需要把上面的内容 打印输出，所以不需要管输出
        println("it：$it")
    }
}