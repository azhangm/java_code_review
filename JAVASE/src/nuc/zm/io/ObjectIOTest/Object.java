package nuc.zm.io.ObjectIOTest;

import org.junit.Test;

import java.io.*;

public class Object   {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person( );
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("demo1.txt"));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        File file = new File("demo1.txt");
//
        Person person1 = deSerialize(file);
        System.out.println(person1.age);
        System.out.println(person1.name);
    }



//  标识接口 （什么都没有的接口）
    private static class Person implements Serializable {
        public static final long serialVersionUID = 1312312313L;

        static int age;
        static String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public Person() {
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


    public static Person deSerialize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) ois.readObject();
        ois.close();
        return person;
    }
}
