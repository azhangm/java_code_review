package nuc.zm;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparator<Student> {

    int age;
    String name;
    public Student (){

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Student zm = new Student(18, "zm");
        Student lhl = new Student(20, "lhl");
        Student[] students = {zm,lhl};
//        System.out.println(lhl);
        Arrays.sort(students,new Student());
        System.out.println(Arrays.toString(students));
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

