package nuc.zm.JVM.gc;

/**
 * systemgc测试
 * @description : finalize () 方法的执行时机
 * @author zm
 * @date 2023/02/21
 */
public class SystemgcTest {
    static Object obj;
    public static void main(String[] args) {
        new SystemgcTest();
//        提醒 JVM 垃圾回收期执行 FULL GC ， 但是不能确定是否马上执行gc
//        与 Runtime.getRuntime().gc(); 作用一样

//        full gc 导致程序的暂停.
//
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj == null) System.out.println("对象已死");
        else System.out.println("对象存活");
        obj = null;
//        进行第二次 FULL GC
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj == null) System.out.println("对象已死");
        else System.out.println("对象存活");
    }

//    此方法什么时候会执行 ? 当一个对象首次考虑被回收时,会调用 finalie();  触发了 不一定回收掉
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
//        方法遗言
        System.out.println("finalize 被执行了");
        obj = this;
//        对象没有死成
        System.out.println(obj);
    }
}
