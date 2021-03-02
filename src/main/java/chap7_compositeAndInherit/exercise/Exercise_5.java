package chap7_compositeAndInherit.exercise;

/**
 * 创建两个带有默认构造器的类A和类B，从A中继承产生一个新的类，名为C
 * 并在C内创建一个B类的成员，不要给C编写构造器，创建一个C类的对象并观察其结果
 */
public class Exercise_5 {
    public static void main(String[] args) {
        C c = new C();
        /*
            A类的构造器被调用了
            B类的构造器被调用了

            从上面的打印结果可以看到： 创建C对象的时候，先调用了基类A类的构造器，初始化基类的对象
            再才调用B类的构造器，初始化自己的成员变量对象b
         */
    }
}

class A {
    A() {
        System.out.println("A类的构造器被调用了");
    }
}

class B {
    B() {
        System.out.println("B类的构造器被调用了");
    }
}

class C extends A{
    B b = new B();
}
