package nuc.zm.JVM.gc;

import java.lang.ref.SoftReference;

/**
 * 软引用测试
 *
 * @author zm
 * @date 2023/02/26
 */
public class SoftReferenceTest {
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

        SoftReference<User> userSoftReference = new SoftReference<User>(user);
//        强引用 取消
        user = null;

//      从 软引用重新获取 强引用 对象
        System.out.println(userSoftReference.get());
//      触发 full gc
        System.gc();
        System.out.println("After GC ===================");
//     堆内存空间足够 并没有回收该对象
        System.out.println(userSoftReference.get());

        try {
//            ParOldGen       total 7168K, used 703K [0x00000000ff600000, 0x00000000ffd00000, 0x00000000ffd00000)
            byte[] b = new byte[1024 * 7168 ];
            System.out.println(userSoftReference.get());
        }catch (Throwable e) {
            e.printStackTrace();
        }finally {
//            再次获取 user 看是否被回收了
            System.out.println(userSoftReference.get());
        }

    }
}
