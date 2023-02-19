package nuc.zm.JVM.creatobj;

/**
 * 类角
 * @description 从字节码文件角度看 对象的创建步骤
 * dup : duplicate
 * @author zm
 * @date 2023/02/19
 */
public class ClassAngle {
    public static void main(String[] args) {
//        Customer customer = new Customer();
        Customer customer1 = new Customer("123");
    }
}


class Customer {
    int id = 1001;
    String name;
    Account acct;
    {
        name = "zm";
    }

    public Customer() {
        acct = new Account();
    }

    public Customer(String name) {
        this.name = name;
    }
}

class Account {

}