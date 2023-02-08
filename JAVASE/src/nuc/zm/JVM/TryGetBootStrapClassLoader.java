package nuc.zm.JVM;

import java.util.List;

/**
 * 试着得到引导类装加载器
 * @description  自定义的类使用 系统类加载器 其他使用引导类加载器
 *   对与 数组类型的 看他的类型 来判断加载器。
 * @author zm
 * @date 2023/02/08
 */
public class TryGetBootStrapClassLoader {
    public static void main(String[] args) {
//        获取 系统类加载器  sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
//        获取 扩展类加载器   sun.misc.Launcher$ExtClassLoader@677327b6
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
//        尝试获取引导类类加载器 ( C ++ 编写)   null
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        System.out.println(List.class.getClassLoader()); // null


    }
}
