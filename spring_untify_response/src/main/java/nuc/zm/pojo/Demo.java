package nuc.zm.pojo;



public class Demo {

    private Integer id;


    private String name;

    public Demo() {
        System.out.println("走无参构造");
    }


    public Demo(Integer id) {
        System.out.println("走一个参数");
        this.id = id;
    }

    public Demo(Integer id, String name) {
        System.out.println("走的是有参构造");
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("走set 方法");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("走set 方法");
        this.name = name;
    }
}
