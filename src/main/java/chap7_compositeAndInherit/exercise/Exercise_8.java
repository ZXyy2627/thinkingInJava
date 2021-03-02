package chap7_compositeAndInherit.exercise;

/**
 * 练习8：
 * 创建一个基类，它仅有一个非默认构造器，再创建一个导出类，它带有默认构造器和非默认构造器。在导出类
 * 的构造器中调用基类的构造器。
 */
public class Exercise_8 {
    public static void main(String[] args) {
        B2 b2 = new B2();
        B2 b21 = new B2("cccccc");
    }
}

class A2{
    A2(String s) {
        System.out.println("基类A2的构造器被调用了==="+s);
    }
}

class B2 extends A2{
    B2(){
        super("aaa");
        System.out.println("B2的无参构造器被调用了");
    }

    B2(String s){
        super(s);
        System.out.println("B2的有参构造器被调用了");
    }
}
