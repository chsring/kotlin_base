/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/4 in out P110
// 生产者out T 协变 此范型能够被获取读取，所以是 out，不能被修改。出去是让你读
interface Producer<out T> {
    //开启只读模式; out T 代表整个生产者类里面，这个T只能被读取，不能被修改
//    fun consume(item: T) 修改报错

    fun produce(): T
}

//消费者 in T 逆变 只能修改，不能读取. 进来就是修改
interface Consumer<in T> {
    fun consumer(item: T)

//    fun produce(): T  读取报错
}

//生产者 和消费者 ，默认情况下 是不变
interface ProducerAndConsumer<T> {
    fun consume(item: T)

    fun produce(): T
}

open class Animal
open class Humainty : Animal()
open class Man : Humainty()
open class Woman : Humainty()

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>生产者
class ProduceClass1 : Producer<Animal> {
    override fun produce(): Animal {
        var t: String
        println("生产者 Animal")
        return Animal()
    }
}

class ProduceClass2 : Producer<Humainty> {
    override fun produce(): Humainty {
        println("生产者 Humainty")
        return Humainty()
    }
}

class ProduceClass3 : Producer<Man> {
    override fun produce(): Man {
        println("生产者 Man")
        return Man()
    }
}

class ProduceClass4 : Producer<Woman> {
    override fun produce(): Woman {
        println("生产者 Woman")
        return Woman()
    }
}

// TODO: 2022/4/5 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  in 逆变 

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>生产者
class ConsumerClass1 : Consumer<Animal> {
    override fun consumer(item: Animal) {
        println("消费者者 Animal")
    }
}

class ConsumerClass2 : Consumer<Humainty> {

    override fun consumer(item: Humainty) {
        println("消费者 Humainty")
    }
}

class ConsumerClass3 : Consumer<Man> {
    override fun consumer(item: Man) {
        println("消费者 Man")
    }
}

class ConsumerClass4 : Consumer<Woman> {
    override fun consumer(item: Woman) {
        println("消费者 Woman")
    }
}

fun main() {
    //默认情况下  范型子类对象 ⚠️不可以赋值给 范型的父类对象  List<CharSequence> list = ArrayList<String>(); 报错❌
    //List<？ extends CharSequence> list = ArrayList<String>() 正确
    // TODO: 2022/4/4 out 协变 ：范型子类对象 可以赋值给 范型的父类对象；类似于  ? extends T
    // TODO: 2022/4/5 默认情况下：范型具体处的子类 是不可以赋值给 范型声明处的父类
    val p1: Producer<Animal> = ProduceClass1() //ProduceClass1 本来就是 传递 Animal,当然可以
    val p2: Producer<Animal> = ProduceClass2() //ProduceClass2 本来就是 传递 Humainty 居然也可以，因为是out
    val p3: Producer<Animal> = ProduceClass3() //ProduceClass3 本来就是 传递 Man 居然也可以，因为是out
    val p4: Producer<Animal> = ProduceClass4() //ProduceClass4 本来就是 传递 Woman 居然也可以，因为是out

    // TODO: 2022/4/5 in 逆变（父类赋值给子类，属于逆行） ： 范型具体处父类 可以赋值给 范型声明处的子类；类似于 ? super T
    // TODO: 2022/4/5 默认情况下，范型具体处父类 不可以赋值给 范型声明处的子类
    // List<String> list = ArrayList<CharSequence>(); 报错
    // List<? super String> list = ArrayList<CharSequence>(); 报错
    val pp1: Consumer<Man> = ConsumerClass1()
    val pp2: Consumer<Woman> = ConsumerClass1()

    // 协变： out 父类 赋值给 子类
    // 逆变： in 子类 赋值给 父类

}

