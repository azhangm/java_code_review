package nuc.zm.io;

import org.junit.Test;

import java.io.*;

/**
 * 输入输出流测试

 引入io流 ： 程序和数据源之间的桥梁
 数据源可以是各种类型 ： 文件 内存 数据库资源 网络资源 io资源

 数据源 ===> 程序 ： 输入流
 程序 ===》 磁盘某个位置 输出流。

 大小划分 ：
 字节流
 字符流

 两类整合 ： 输入字符/字节 流
 输出字符/字节流

 功能分 ： 节点流 ：我一人完成任务足以
 处理流 ： 管 套 节点流管  必须和节点流组合使用 更强了


 案例 ： 复制文件
 */

public class IOPractice {

    @Test
    public void copyFile() throws IOException {
        File file = new File("C:\\Users\\74282\\Desktop\\acwing.txt");
        File file1 = new File("Ac.txt");
        FileInputStream fileInputStream;
        if (file.exists()) {
            fileInputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            FileOutputStream fos = new FileOutputStream(file1);
            System.out.println(file.length());
            while (  fileInputStream.read(b) != -1 ) {
                fos.write(b);
            }
             fileInputStream.close();
        }



    }


    @Test
    public void fileReader() throws IOException {
        File file = new File("C:\\Users\\74282\\Desktop\\acwing.txt");
        File file1 = new File("ac-editor.txt");
        FileReader fr = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);
        char[] c = new char[5];

//        一次读五个字符 返回的是这个数组中的有效长度
        int read = fr.read(c);
        while (read != -1) {
            for (int i = 0; i < c.length; i++) {
//                这里输出如果是加空格的话 不能正常输出 不知道什么问题 不加空格的话 就是正常输出
//                System.out.print(c[i]  + " ");
                System.out.print(c[i]);
            }
            System.out.println("==========分次读分割线===========");
            fileWriter.write(c);
            read = fr.read(c);
        }
        fr.close();
        fileWriter.close();
    }
}
