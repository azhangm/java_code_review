package nuc.zm.MoreThread;

/**
 * cpu num
 *
 * @author zm
 * @date 2022/10/25
 */
public class CpuNum {
    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        处理器个数
//        System.out.println("processor nums : " +  runtime.availableProcessors());
//String.intern()方法
//存在于。class文件中的常量池，在运行期被JVM装载，并且可以扩充。String的intern()方法就是扩充常量池的一个方法;当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用;参照如下代码：
        String s = "123";
        String intern = s.intern();
        String s1 = new String("123");
        System.out.println(intern == s); //true
        System.out.println(s1 == s); // false
        System.out.println(s1 == s1.intern()); //false
        System.out.println(s1.intern());
        s1 = "1234";
        System.out.println(s1);
        String intern1 = s.intern();
        System.out.println(intern1);
    }
}
