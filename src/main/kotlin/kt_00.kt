/**
 * todo ============关键字大全===============
 * fun 函数声明
val / var 变量声明
field
== 检查相等性（类似于Java中的equals方法）
=== 进行引用比较
is 等价于Java中的instanceOf
data class 数据类（自动生成方法的实现类）
by 委托
object 声明对象（单一实例，无构造方法）
companion object 伴生对象（工厂方法，静态成员）
object : 声明匿名内部类
maxBy{} 指定比较哪个值找到最大元素，需要一个参数：一个函数
it 默认参数名称
:: 成员引用（Person::age）
{… -> …} Lambda表达式
run{} 执行代码块
filter 过滤（从集合中找寻满足条件的所有元素）
map 转换（对集合中的每一个元素应用给定的函数并把结果收集到一个新集合）
all 判断集合中的所有元素是否满足某个条件 返回布尔值类型
any 判断集合中是否至少有一个元素满足条件 返回布尔值类型
count 返回集合中满足条件的个数
find 找到集合中第一个满足条件的元素，如果没有返回Null 等价于 firstOrNull
groupBy 根据条件把集合转换成分组的map
flatMap 根据作为实参给定的函数对集合中的每个元素做变换，然后把多个列表合并成一个列表
asSequence() 把任意的集合转换成序列 （惰性操作）
toList 把序列转换成集合
with(params){} with的返回值是lambda中最后一个表达式
apply apply始终会返回作为实参传递给它的对象（返回接收者的对象），返回第一个参数
？ 允许变量为null
?. 安全调用
?: Elvis运算符（不为null就是前面的运算数，为null就是后面的运算数）
as? 安全转换
!!. 非空断言
let函数 ?.let{} 把调用Lei函数的可空对象转换成非空类型
lateinit 延迟初始化， 所有延迟初始化都是var类型
Any , Any? 根类型（前者非空，否则可为空）
Unit Kotlin中的void
Nothing 这个函数永不返回
operator 重载符号
a[index] 下标运算符 重载get()方法
in 检查某个对象是否属于集合
rangeTo 创建区间…
by 委托
by lazy{} 延迟初始化
inline 内联函数关键字，作用：销除lambda带来的运行开销
where 指定泛型的多个约束
reified 具体化，使用inline来修饰函数，reified来修饰类型形参，作用：可以在运行时引用实际的类型参数
::class.java 获取java.lang.Class对应的Kotlin类
out 泛型中协变关键字 作用：保留子类型化关系，泛型T只能用在out位置（返回值）相当于Java中的extends
in 逆变，可以看作是协变的镜像 相当于Java中的super
@ 应用注解，lambda中做局部返回

作者：朱_c713
链接：https://www.jianshu.com/p/0c3544098054
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
  */











fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // TODO: 2022/3/17  声明变量

    var name : String = "derry"
    name = "Lance"
    println(name)

    /**
     * String
     * Char
     * Boolean true/false
     * Int
     * Double
     * List
     * Set 无重复的元素集合
     * Map
     *无 int ，float
     */

}