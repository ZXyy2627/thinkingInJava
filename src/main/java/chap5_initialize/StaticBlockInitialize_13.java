package chap5_initialize;

/**
 * 显示的静态初始化
 *
 * 静态代码块也只会执行一次
 */
public class StaticBlockInitialize_13 {
/*
    Cup(1)
    Cup(2)
    Cups的构造器执行了
            Cups的构造器执行了
    main方法内部
    从打印结果看到，静态代码块初始化cup1和cup2对象的程序只执行了一次，但是这里创建了两个cups对象，所以得出结论
    静态代码块只会执行一次
    */
    static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();
    public static void main(String[] args) {
        System.out.println("main方法内部");
        //Cups.cup1.f(99);
        /*
        Cup(1)
        Cup(2)
        f(99)
        从打印结果看到，静态代码块也只执行了一次，创建了两个Cup对象,但是cups的构造器根本就没有执行
         */
    }
}

class Cup {
    Cup(int i) {
        System.out.println("Cup("+i+")");
    }

    void f(int i) {
        System.out.println("f("+i+")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static{
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups的构造器执行了");
    }
}
