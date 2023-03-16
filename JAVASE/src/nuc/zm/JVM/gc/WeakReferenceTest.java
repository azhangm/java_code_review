package nuc.zm.JVM.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 弱引用测试
 *
 * @author zm
 * @date 2023/02/26
 */
public class WeakReferenceTest {
    public static  class User {
        public   String name;
        public int id;

        public User (int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return  "id  " + id  + "name "  + name;
        }
    }

    public static void main(String[] args) {
        User user = new User(1,"zm");
        WeakReference<User> weakReference = new WeakReference<>(user);
//        强引用 取消
        user = null;

//      从 软引用重新获取 强引用 对象
        System.out.println(weakReference.get());
//      触发 full gc
        System.gc();
        System.out.println("After GC ===================");
//     堆内存空间足够 并没有回收该对象
        System.out.println(weakReference.get());

    }

}
