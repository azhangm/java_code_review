package nuc.zm.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 文件类 练习
 *
 * @author zm
 * @date 2022/10/11
 */
public class FilePractice {
    /**
     * test01
     * @description 建议写法 ：跨平台 使用 separator ： 获取当前操作系统的路径拼接符号
     * @description file 文件类的api 复习
    **/

     @Test
    public void test01() throws IOException {
        File file = new File("E:" + File.separator + "zio-test" + File.separator + "io-test01.txt");
//        常用方法汇总
         System.out.println("文件路径  : " +  file.getAbsolutePath());
         System.out.println("文件是否可读 : "  + file.canRead());
         System.out.println("文件是否可写 :" + file.canWrite());
         System.out.println("文件的名字 : " + file.getName());
         System.out.println("文件的上级目录 : " + file.getParent());
         System.out.println("文件是否是一个目录 ? " + file.isDirectory());
         System.out.println("文件是否是隐藏的 ：" + file.isHidden());
         System.out.println("文件的大小是多少 ： " + file.length());
         System.out.println("文件是否存在 : " + file.exists());

//         if (file.exists()) {
//             System.out.println("文件存在 现在被我删除了");
//             file.delete();
//         }else {
//             System.out.println("没有这个文件 我要创建他 hh");
//              file.createNewFile();
//         }
      System.out.println(":=============测比较===============");
         File file1 = new File("E:" + File.separator + "zio-test" + File.separator + "io-test01.txt");
         System.out.println("相等 比较的是路径");
         System.out.println("file 和 file1 是否相等" + (file.equals(file1)));
         System.out.println("不相等 比较的是内存地址");
         System.out.println( file == file1);


         System.out.println(":=============测路径===============");
         System.out.println("绝对路径（精准路径）" + file.getAbsolutePath());
         System.out.println("相对路径（相对参照物）" + file.getPath());
         System.out.println("toString : " + file);

         System.out.println("=================直接创建文件是在哪创建的===============");
         File file2 = new File("demo.txt");
         if (file2.exists()) {

         }else {
             file2.createNewFile();
         }

         System.out.println("file2 的绝对路径" + file2.getAbsolutePath());
         System.out.println("file2 的相对路径 :" + file2.getPath());
         System.out.println("file2 的不知道什么路径" + file2.getCanonicalPath());
         System.out.println("file2 的toString  : " + file2);


         System.out.println("toString 的结果永远是相对路径");
     }
    /**
     * 测试dir
     * 文件类对目录进行操作
     */
    @Test
     public void testDir() {
        File file = new File("E:" + File.separator + "zio-test" + File.separator + "test-dir");
        System.out.println("生成单级目录~~~~");
//        对已有的目录 不做创建处理 也就是说不会覆盖
        file.mkdir();
        System.out.println("创建多级目录 二次运行测试是否会覆盖");
        File file1 = new File("E:" + File.separator + "zio-test" + File.separator + "test-dir" + File.separator + "a" + File.separator + "b" + File.separator + "c");
        System.out.println("生成多级目录~~~~~");
        file1.mkdirs();
        System.out.println("delete 只会删除最里层的  有内容的话 则不会删除");
        file.delete();
        file1.delete();

        File file2 = new File("D:" );
        System.out.println("输出目录下的文件列表i  获得信息 了 就可以递归遍历了 ");
        if (file2.isDirectory()) {
            for (java.lang.String s : Objects.requireNonNull(file2.list())) {
                System.out.println(s);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        System.out.println(new File("hello/test.txt"));
        System.out.println(new File("hello/test.txt").getAbsolutePath());
    }

}
