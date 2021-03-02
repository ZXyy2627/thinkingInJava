package chap7_compositeAndInherit.exercise;

/**
 * 用Chess.java来证明调用基类构造器必须是你在导出类构造器中要做的第一件事，否则编译器报错
 */
public class Exercise_6 {
    public static void main(String[] args) {
        Exercise6Extend exercise6Extend = new Exercise6Extend();
    }
}

class Exercise6 {
    Exercise6(int i) {
        System.out.println("Exercise6的构造器被调用了");
    }
}

class Exercise6Extend extends Exercise6 {
    Exercise6Extend() {//此时什么都不写，编译器就已经在报错了  我们看看IDEA给的错误提示
        //System.out.println("如果不把super调用基类构造器放在第一行，编译器会报错");
        super(11);//看看IDEA给的错误提示  Call to 'super()' must be first statement in constructor body
        System.out.println("Exercise6Extend的构造器被调用了");
    }
}
