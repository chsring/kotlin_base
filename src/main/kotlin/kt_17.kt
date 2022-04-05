/**
 * Description:
 * Created by small small su
 * Date: 2022/4/3
 * Email: surao@foryou56.com
 */

// TODO: 2022/4/4 接口
//接口所有成员 和 接口本身 都是 public 和 open的，所以不需要 open
//接口 不能有主构造
//实现类 不仅仅要重写接口函数，还要重写接口成员
//接口实现代码区域，全部都要增加关键字 override 来实现
interface IUSB {
    var usbVersionInfo: String
    var usbInsertDevice: String
    fun insertUsb(): String
}

//鼠标 usb 实现类
class Mouse(
    override var usbVersionInfo: String = "USB 3.0",
    override var usbInsertDevice: String = "鼠标介入了USB口"
) : IUSB {
    override fun insertUsb(): String = "Mouse $usbVersionInfo , $usbInsertDevice"
}

//键盘usb实现类 : 可以继承，可以实现
class KeyBoard : IUSB {
    override var usbVersionInfo: String = ""
        //下面的set和get都会持有field ，现在是没有给 usbVersionInfo 赋值,意味着
        //是没法让field持有的，必须 给usbVersionInfo赋初试值
        get() = field
        set(value) {
            field = "USB 3.1 :$value"
        }
    override var usbInsertDevice: String = ""
        get() {
            println("你获取了[$field]")
            return field
        }
        set(value) {
            field = value
            println("你set了[$value]")
        }

    override fun insertUsb(): String = "KeyBoard $usbVersionInfo , $usbInsertDevice"
}

// TODO: 2022/4/4 接口默认实现 有这个功能 但是不要用
//因为接口成员 本来就是声明标准的，只不过 可以在接口成员声明时候 完成对接口成员的实现
interface IUSB2 {
    //1. 接口如果是var ，不能给接口成员赋值，但是有其他办法
    //2. 任何类 接口 val 代表只读的，不可以在后面动态赋值,也有其他办法
    val usbVersionInfo: String
        //val 无set
        get() = (1..100).shuffled().last().toString()

    val usbInsertDevice: String
        get() = "高级设备接入USB"

    fun insertUsb(): String
}
//鼠标 usb 实现类
class Mouse2 : IUSB2 {
    override val usbInsertDevice: String
        get() = super.usbInsertDevice
    override fun insertUsb(): String = "Mouse $usbVersionInfo , $usbInsertDevice"
}

//键盘usb实现类 : 可以继承，可以实现
class KeyBoard2 : IUSB2 {
    override var usbVersionInfo: String = ""
        //下面的set和get都会持有field ，现在是没有给 usbVersionInfo 赋值,意味着
        //是没法让field持有的，必须 给usbVersionInfo赋初试值
        get() = field
        set(value) {
            field = "USB 3.1 :$value"
        }
    override var usbInsertDevice: String = ""
        get() {
            println("你获取了[$field]")
            return field
        }
        set(value) {
            field = value
            println("你set了[$value]")
        }

    override fun insertUsb(): String = "KeyBoard $usbVersionInfo , $usbInsertDevice"
}


fun main() {

    val iusb1: IUSB = Mouse()
    println(iusb1.insertUsb())
    val iusb2: IUSB = KeyBoard()
    println(iusb2.insertUsb())
    iusb2.usbInsertDevice = "AAA"
    println(iusb2.insertUsb())

}



















