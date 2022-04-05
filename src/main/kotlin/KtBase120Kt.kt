/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
// TODO: 2022/4/5 扩展文建 一般都是 public 否则外面无法使用 可以把很多个扩展文件写到一个地方

//扩展父类，父类子类都可以用。
public fun <E> Iterable<E>.randomItem() = this.shuffled().first()

public fun <T> Iterable<T>.randomItemPrint() = println(this.shuffled().first())