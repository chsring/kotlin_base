/**
 * Description:
 * Created by small small su
 * Date: 2022/4/4
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/4 抽象类
abstract class BaseActivity {
    fun onCreate() {
        setContentView(getLayout())
        initView()
        initData()
        initXXX()
    }

    private fun setContentView(layoutID: Int) = println("加载到$layoutID xml布局中")

    abstract fun getLayout(): Int
    abstract fun initView()
    abstract fun initData()
    abstract fun initXXX()
}

class MainActivity : BaseActivity() {
    override fun getLayout(): Int = 546

    override fun initView() {
        println("初始化View")
    }

    override fun initData() {
        println("初始化Data")
    }

    override fun initXXX() {
        println("初始化XXX")
    }

    fun show() {
        super.onCreate()
    }
}

fun main() {
    MainActivity().show()
}