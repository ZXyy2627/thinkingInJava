package chap7_compositeAndInherit.exercise;

/**
 * 证明：即使不为Cartoon类提供构造器，他也会为Cartoon类合成一个默认的构造器，并且该构造器将调用基类的构造器
 */
public class Exercise_3 {
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
        /*
            Art的构造器被调用了
            Drawing的构造器被调用了

            从打印结果可以看到，即使没有给Cartoon类提供构造器，编译器还是会为Cartoon组合一个默认的构造器，
            并且调用基类的构造器
         */
    }
}

class Art {
    Art() {
        System.out.println("Art的构造器被调用了");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing的构造器被调用了");
    }
}

class Cartoon extends Drawing {
    //这里不提供任何构造器
}
