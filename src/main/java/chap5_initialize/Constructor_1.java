package chap5_initialize;

/**
 * 什么是构造器？
 * 构造器是用于初始化对象的一个方法,构造器能够保证对象被初始化
 *
 * 构造器与类名相同，没有返回值，也不是void
 *
 * 如果一个类中有带参的构造器，那么编译器不会创建默认的无参构造器
 */
public class Constructor_1 {
    public static void main(String[] args) {
        Rock rock = new Rock();
    }
}

class Rock{
    public Rock() {
        System.out.println("这是一个无参构造器，也是该类的默认构造器");
    }
}
