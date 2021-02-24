package chap5_initialize;

/**
 * 静态数据的初始化
 *
 * 静态数据的初始化的时间时在类加载的时候
 */
public class StaticDataInitialize_12 {
    public static void main(String[] args) {

    }
}

class Bowl{
    public Bowl(int i) {
        System.out.println("Bowl("+i+")");
    }

    public void f1(int j) {
        System.out.println("f1()被调用");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("table的构造方法执行了");
    }

    void f2(int i) {
        System.out.println("f2()被调用了");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("cupboard的构造器执行了");
        bowl4.f1(2);
    }

    void f3(int i) {
        System.out.println("f3()方法执行了");
    }

    static Bowl bowl5 = new Bowl(5);
}
