import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/4/6
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/6  DSL 学习
//  DSL 领域专用语言, 其实 applyFile 函数 就是DSL编程范式，定义输入输出规则

class Context {
    val info = "我就是Derry"
    val name = "DDD"

    fun toast(str: String) {
        println("toast ： $str")
    }
}

// 进行DSL 规则
inline fun Context.apply5(lambda: Context.(String) -> Unit): Context {
    //this 可以省略掉
    lambda(info)
    return this  //永远返回 Context ，可以链式调用
}

//applyFile 进行DSL 规则
inline fun File.applyFile(action: (String, String?) -> Unit): File {
    action(name, readLines()[0])
    return this
}

fun main() {
    // 其实 apply5就属于DSL 编程范式，定义了输入输出的规则
    // 输入规则：必须是Context类，才有资格使用
    // 输出规则：始终返回Context本身,所以可以链式调用
    val context = Context().apply5 {
        //  this 和 it 都持有
        println(" it : $it, this : $this")
        toast("success")
        toast(it)
        toast(name)
    }

    File(filePath).applyFile { fileName: String, data: String? ->
        println("文件名:$fileName, 数据:$data")
        true
    }.applyFile { a, b ->
        println("文件名:$a, 数据:$b")
    }
}