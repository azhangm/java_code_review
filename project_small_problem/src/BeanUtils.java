/**
 * 豆跑龙套
 *  模拟官方 BeanUtils 里面的 copy 方法
 *  技术 ： 反射
 * @author zm
 * @date 2022/10/10
 */
public class BeanUtils {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Void> c1 = void.class;
        Class<Integer> c2 = int.class;
        Class<Boolean> c3 = boolean.class;
        Class<int[]> c4 = int[].class;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("java.lang.String");
        Class<? extends String> aClass1 = "string".getClass();
        System.out.println(aClass==aClass1);
    }
}
