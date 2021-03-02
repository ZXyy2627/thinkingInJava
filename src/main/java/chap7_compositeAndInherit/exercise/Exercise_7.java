package chap7_compositeAndInherit.exercise;

/**
 * 练习7  修改练习5，使A和B以带参的构造器取代默认的构造器，为C写一个构造器，并在其中执行所有的初始化
 */
public class Exercise_7 {
    public static void main(String[] args) {
        C1 c1 = new C1(11);
    }
}

class A1 {
    A1(int i) {
        System.out.println("A1的构造器被调用了");
    }
}

class B1 {
    B1(int i) {
        System.out.println("B1的构造器被调用了");
    }
}

class C1 extends A1 {
    private B1 b1;
    C1(int i) {
        super(i);
        System.out.println("C1的构造器被调用了");
        b1 = new B1(i);
    }
}
