import java.util.Arrays;
import java.util.Comparator;

public class Student  {

    int age;
    String name;
    public Student (){

    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
//        Student lhl = new Student(20, "lhl");
//
//        Student zm = new Student(18, "zm");
//        Student zzb = new Student(120, "zzb");
//        Student[] students = {zm,lhl,zzb};
//        Arrays.sort(students,new Student());
//        for (Student student : students) {
//            System.out.println(student);
//        }

//        int i = i.
//    两种调用方式
            int a = new Student().add(1,2);
        System.out.println(a);
        Student student = new Student();
        System.out.println(student.add(1, 2));
    }

    public    int add(int a,int b)
    {
        int i= a+b;
        return i;
    }
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o2.age - o1.age;
//    }

    @Override
    public String toString() {
        return age + "" + "   name   " + name;
    }

    class  a  implements  Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}
