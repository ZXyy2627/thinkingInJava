package chap5_initialize;

/**
 * 初始化的顺序
 *
 * 在类的内部，变量定义的顺序决定了初始化的顺序，无论成员变量的定义在什么位置，成员变量的初始化一定在调用构造器之前
 */
public class OrderOfInitialize_11 {
    public static void main(String[] args) {
        House house = new House();
        house.f1();
        /*
        Window(1)
        Window(2)
        Window(3)
        House的构造器执行了
        Window(33)
        f1方法执行了

        从打印结果看出：
        w1,w2,w3对象都是在House的构造器还没有执行的时候，就已经被初始化了，并调用了Window的构造器
        他们都是成员变量

        所以上述结论：
        只要是类的成员变量，在还没有调用该类的构造器时就已经被初始化了，并且只要是成员变量，无论它在类中哪个位置，哪怕是在
        最后，也会先被初始化
         */

    }
}

class Window{
    public Window(int i) {
        System.out.println("Window("+i+")");
    }
}

class House{
    Window w1 = new Window(1);

    public House() {
        System.out.println("House的构造器执行了");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    public void f1() {
        System.out.println("f1方法执行了");
    }

    Window w3 = new Window(3);
}
