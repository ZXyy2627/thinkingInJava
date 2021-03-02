package chap7_compositeAndInherit;

/**
 * 继承中的初始化：
 * 通过练习3，4，5总结：
 * 1.基类的构造器总是会被调用，即使不显示的调用，也会被隐式的调用
 * 2.先调用基类的构造器，再调用导出类的构造器
 * 3.即使在导出类中，不写任何构造器，编译器也会默认地组合一个构造器给导出类，并在这个组合的构造器中先调用基类构造器
 */
public class Cartoon_5 extends Drawing{
    Cartoon_5() {
        System.out.println("Cartoon的构造器被调用了");
    }

    public static void main(String[] args) {
        Cartoon_5 x = new Cartoon_5();
        /*
            Art的构造器被调用了
            Drawing的构造器被调用了
            Cartoon的构造器被调用了

            从打印结果看，我们知道在创建子类对象的时候，会先初始化基类对象，并且在继承结构中是从上至下的
            所以可以知道，在创建Cartoon对象的时候，是默认调用了基类的构造方法的
         */
    }
}

class Art{
    Art() {
        System.out.println("Art的构造器被调用了");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing的构造器被调用了");
    }
}
