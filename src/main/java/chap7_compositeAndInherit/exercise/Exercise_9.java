package chap7_compositeAndInherit.exercise;

/**
 * 创建一个Root类，令其含有Component1,Component2,Component3的类的各一个实例，
 * 从Root类派生一个Stem类，也含有上述的各组成部分。所有的类都应带有可打印出类的相关信息的构造器
 */
public class Exercise_9 {
    public static void main(String[] args) {
        Stem stem = new Stem();
        /*
            Component1类的构造器执行了
            Component2类的构造器执行了
            Component3类的构造器执行了
            Root类的构造器执行了
            Component1类的构造器执行了
            Component2类的构造器执行了
            Component3类的构造器执行了
            Stem类的构造器执行了

            从打印结果看出，继承关系中会先初始化基类的成员，在初始化基类对象
            然后Root类也是一样，类加载的时候就初始化了成员，然后再调用构造器初始化对象
         */
    }
}

class Component1 {
    Component1() {
        System.out.println("Component1类的构造器执行了");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2类的构造器执行了");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3类的构造器执行了");
    }
}

class Root {
    private Component1 component1 = new Component1();
    private Component2 component2 = new Component2();
    private Component3 component3 = new Component3();
    Root(){
        System.out.println("Root类的构造器执行了");
    }
}

class Stem extends Root{
    private Component1 component1 = new Component1();
    private Component2 component2 = new Component2();
    private Component3 component3 = new Component3();
    Stem(){
        System.out.println("Stem类的构造器执行了");
    }
}

