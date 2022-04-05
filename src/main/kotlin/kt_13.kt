/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/3 Any 相当于 java中的Obj
//Any 类在KT设计中只提供标准，看不见实现，实现 在各个平台里面设计好了，但是java中的obj是可以看到实现的
class obj : Any()

//todo kt语言对象的声明学习
object KtBase87 {
    /**
     *  public static final KtBase87 INSTANCE;
     *  private KtBase87(){} //主构造已经被废除
     *
     *  static {
     *      //静态代码块放init 里面的内容
     *  }
     */
    init {
        println("KtBase87 init...")
    }

    fun show() = println("我是show函数...")
}

// TODO: 2022/4/3 对象表达式
open class KtBase88 {
    open fun add(info: String) = println("add:$info")

    open fun del(info: String) = println("del:$info")
}

class KtBase88Impl : KtBase88() {
    override fun add(info: String) {
        super.add(info)
        println("我是具名对象 add:$info")
    }

    override fun del(info: String) {
        super.del(info)
        println("我是具名对象 del:$info")
    }

}

// TODO: 2022/4/3 半生对象  只会初始化一次
// TODO: 2022/4/5 Kotlin中没有静态变量，So，它使用了伴生对象来模仿Java中静态变量的作用。 伴生对象也是在类加载初始化，
//  同样生命周期与该类的生命周期一致且也可以直接通过类名.(attribute,method)来调用该类的多个对象共享该伴生对象。
class KtBase89 {
    //伴生对象 相当于static
    companion object {
        val info = "DerryInfo"
        fun showInfo() = println("显示:$info")
    }
    /**
     * 伴生对象 背后的逻辑
     *    public static final  KtBase89.Campaion companion = new KtBase89.Companion
     *      public static final class Campaion{
     *      void  showInfo(){}
     *       getInfo(){}
     *       private Campaion(){}
     *      }
     */

}

fun main() {
    println(obj().toString())

    //object KtBase87 既是单例实例，也是类名 只有一份，因为是单例
    //小结：既然是单例的实例，又是累名，只有一个创建，这就是典型的单例
    println(KtBase87)
    println(KtBase87)
    println(KtBase87.show()) //区别于  KtBase87().show()

    //匿名对象表达方式
    val p: KtBase88 = object : KtBase88() {
        override fun add(info: String) {
//            super.add(info)
            println("我是匿名对象 add:$info")
        }

        override fun del(info: String) {
//            super.del(info)
            println("我是匿名对象 del:$info")
        }
    }

    p.add("李元霸")
    p.del("李连杰")

    //具名方式
    val p2 = KtBase88Impl()
    p2.add("李元霸")
    p2.del("李连杰")

    //对java接口 使用对象表达式
    val p3 = object : Runnable {
        override fun run() {
            println("Runnable p3 run ... ")

        }

    }
    p3.run()

    //对java的接口 用java的方式
    val p4 = Runnable {
        println("Runnable p4 run ... ")
    }
    p4.run()

    // TODO: 2022/4/3 伴生对象的由来：Kt中 没有给java的static，伴生对象很大程度上和java的static差不多
    println(KtBase89.info)
    KtBase89.showInfo() // KtBase89.Companion.showInfo()
    // 无论  KtBase89() 多少次，我们的伴生对象 只有一次加载
    KtBase89()
    KtBase89()
    KtBase89()
    KtBase89()
    KtBase89()



}


