package nuc.zm.JVM.runtimearea;

import java.util.Date;

/**
 * 局部变量表测试
 * @description  通过测试 编译完成之后 局部变量表的大小是被确定了的
 *               方法的嵌套调用又由栈的大小来决定。
 *               局部变量表中的变量只在当前方法调用中有效 生命周期与栈帧相同
 * @author zm
 * @date 2023/02/12
 */
public class LocalVariableTableTest {


    public static void main(String[] args) {
        LocalVariableTableTest localVariableTableTest = new LocalVariableTableTest();
        localVariableTableTest.test();
        int num = 10;
    }
// 非 static 方法的局部变量表 会加入 this 局部变量表大小为 4
    private void test() {
        LocalVariableTableTest localVariableTableTest = new LocalVariableTableTest();
        Date date = new Date();
        String name = "zm";
        System.out.println(date + name);
    }
//  static方法的局部变量表不加入 this  这个局部变量表大小为 3
    public static void testStatic() {
        LocalVariableTableTest localVariableTableTest = new LocalVariableTableTest();
        String name = "";
        Date date = new Date();
    }
//  double 和 long 会占用两个slot 占 6 个  操作数栈最大深度 2 局部变量最大槽数 6 字节码长度 33
    public String test(Date test , String name) {
        test = null;
        name = "12";
        double weight = 13.0;
        char gender = '男';
        return test + name;
    }

//  slot 复用问题 一个变量超过了作用域 作用域外的代码会复用超过作用域的变量的槽位
//    局部变量表大小 3 this a b
    public void test1 () {
        int a = 0;
        {
            int b = a;
             a  = 1;
        }
        int c = a + 1;

        int d = c;
    }
}