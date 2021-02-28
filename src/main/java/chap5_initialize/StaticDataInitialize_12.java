package chap5_initialize;

/**
 * 静态数据的初始化
 *
 * 静态数据的初始化的时间时在类加载的时候
 */
public class StaticDataInitialize_12 {
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
    public static void main(String[] args) {
        new Cupboard();
        System.out.println("再创造一个Cupboard");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
/*
        Bowl(1)             静态数据是再类加载的时候就初始化了，这里先有了一个Table类的静态对象，所以这里先初始化table对象  再看table类，它也有静态数据
        Bowl(2)         bowl1和bowl2，所以对于talbe来说它要先初始化的是静态变量bowl1和bowl2，所以会先调用BOWL的构造器，
        table的构造方法执行了  然后才调用table类的构造器
        Bowl(4)             同样的道理，再定义了一个静态的Cupboard对象，那么就先初始化Cupboard类的静态对象，bowl4和bowl5，这时再次调用构造器
        Bowl(5)             我们说成员变量在调用构造器前就已经初始化了，所以成员变量bowl3初始化，调用了构造器,打印了Bowl(3)
        Bowl(3)
        cupboard的构造器执行了     成员变量初始化完了才调用cupboard类的构造器执行，
        f1()被调用                 在构造器内部，向bowl4这个对象发送了f1消息   到此为止，main方法上的两个静态变量已经初始化完毕
        Bowl(3)               main方法开始执行，new Cupboard()这行代码，就又要初始化一个Cupboard对象，但是因为静态变量只加载一次，所以这时不再加载bowl4和bowl5了
        cupboard的构造器执行了  由于bowl3不是静态的，所以它又初始化了一次bowl3,再才调用构造器
        f1()被调用
        再创造一个Cupboard
        Bowl(3)
        cupboard的构造器执行了
        f1()被调用     再次运行new Cupboard()代码，原理同上
        f2()被调用了   然后再向table对象发送消息
        f3()方法执行了 然后再向cupboard发送消息
*/


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
