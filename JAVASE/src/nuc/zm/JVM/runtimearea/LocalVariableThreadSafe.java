package nuc.zm.JVM.runtimearea;

/**
 * 局部变量线程安全
 * @description  方法中定义的局部变量是否安全 ？ 具体问题具体分析
 * @author zm
 * @date 2023/02/14
 */
public class LocalVariableThreadSafe {


    public static void main(String[] args) {
        LocalVariableThreadSafe localVariableThreadSafe = new LocalVariableThreadSafe();
        StringBuilder stringBuilder = new StringBuilder();
        localVariableThreadSafe.method(stringBuilder);
//     哦呦 这个操作使得线程不安全了
        stringBuilder.append("c");

    }

    public static void method1() {
//        SB 线程不安全。  变量在 栈帧里是线程安全的
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
    }


//    StringBuilder的操作过程是线程不安全的。
//    因为   StringBuilder 由外部传进来、有可能多线程操作它
     public void method(StringBuilder sb) {
            sb.append("a").append("b");
    }

//    有可能杯其他线程共享。 堆空间中的对象不会随栈帧对象的消失而销毁
    public static StringBuilder method2 () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b").append("c");
        return stringBuilder;
    }


//    StringBuilder 是线程安全的  toString new 了一个 String对象、sb随栈帧销毁而销毁 没有被其他线程共享的可能性
//    返回的String 对象是线程不安全的。
    public static String method3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c");
        return stringBuilder.toString();
    }
}
