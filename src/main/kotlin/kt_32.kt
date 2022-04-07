/**
 * Description:
 * Created by small small su
 * Date: 2022/4/7
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/7 单例模式

//todo 单例饿汉式
object KtBaseEH

// TODO: 2022/4/7 懒汉
class KtBaseLH {
    companion object {
        private var instance: KtBaseLH? = null
            get() {
                if (field == null) {
                    field = KtBaseLH()
                }
                return field
            }

        @Synchronized // TODO: 2022/4/7 同步锁 用到注解
        fun getInstanceAction() = instance!!
    }

    fun show() {
        println("show")
    }
}

// TODO: 2022/4/7 双检索

class KtBaseDC private constructor() {

    companion object {
        //kotlin 原生方式
        val instance: KtBaseDC by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            KtBaseDC()
        }

        //翻译java写法
        @Volatile
        private var INSTANCE: KtBaseDC? = null
        fun getInstanceDC(): KtBaseDC {
            if (INSTANCE == null) {
                synchronized(KtBaseDC::class) {
                    if (INSTANCE == null) {
                        INSTANCE = KtBaseDC()
                    }
                }
            }
            return INSTANCE!!
        }
    }


    fun show() {
        println("show")
    }
}


fun main() {
    KtBaseLH.getInstanceAction().show()
    KtBaseDC.instance.show()
}