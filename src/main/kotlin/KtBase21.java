/**
 * Description:
 * Created by small small su
 * Date: 2022/3/17
 * Email: surao@foryou56.com
 */
public class KtBase21 {

    public String info;

    // in is 在java中就是普通函数，而在kt中 就是关键字
    public static final void in() {
        System.out.println("in run");
    }

    public static final void is() {
        System.out.println("is run");
    }

    // TODO: 2022/4/7 单例公用：能否 懒加载，线程安全，通过反射破坏（思考 如何拒绝jvm读取类的私有方法：枚举类型单例 无法被反射获取）
    private KtBase21() {
    }

    // TODO: 2022/4/7 单例 饿汉式 很着急就把自己创建出来了
    private static KtBase21 instanceEH = new KtBase21();

    //  安全性高 只会new 一次
    public static KtBase21 getInstanceEH() {
        return instanceEH;
    }

    // TODO: 2022/4/7 懒汉式 调用时在加载
    private static KtBase21 instanceLH;

    public static KtBase21 getInstanceLH() {
        if (instanceLH == null) {
            instanceLH = new KtBase21();
        }
        return instanceLH;
    }

    // TODO: 2022/4/7 懒汉式+安全
    private static KtBase21 instanceLHAQ;

    public static synchronized KtBase21 getInstanceLHAQ() {
        if (instanceLHAQ == null) {
            instanceLHAQ = new KtBase21();
        }
        return instanceLHAQ;
    }

    // TODO: 2022/4/7 双检索 写起来复杂
    private static volatile KtBase21 instanceDC = null;

    // volatile 防止指令重拍
    public static KtBase21 getInstanceDC() {
        if (instanceDC == null) {
            synchronized (KtBase21.class) {
                if (instanceDC == null) {
                    instanceDC = new KtBase21();
                }
            }
        }
        return instanceDC;
    }

    // TODO: 2022/4/7 静态内部类 ：懒加载 + 线程安全 + 写起来方便
    //静态内部类 在程序启动的时候 不会加载;只有第一次调用的时候才加载，利用了jdk类加载机制的特性实现懒加载

    private static class SingleHolder {
        private static final KtBase21 INSTANCE = new KtBase21();
    }

    public static final KtBase21 getInstance() {
        return SingleHolder.INSTANCE;
    }

    // TODO: 2022/4/7 枚举类型单例：并不能因此得出 此方法 比前面优秀,只不过不能被反射获取，jvm获取不到枚举类型的构造器
    // 枚举类型 没有 无参构造函数
    public enum SingleInstance {
        INSTANCE;
    }

}
