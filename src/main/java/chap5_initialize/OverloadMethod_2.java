package chap5_initialize;

/**
 * 方法的重载：
 * 什么是方法的重载，方法名相同，但是参数列表不一样，就是方法的重载
 *
 * 对于构造器的重载而言：作用就是使用不同的方式创建对象
 *
 * 注意事项：
 *  1.对于参数列表而言，参数的个数，参数的类型甚至是参数的顺序不一样，都属于不同的参数列表
 *  放到方法中，这些方法都属于重载方法
 *
 *  2.一般情况下，不要使用参数列表的顺序来区分重载方法  可能会造成误解
 *
 *  3.方法的返回值不能区分重载方法
 */
public class OverloadMethod_2 {
    public static void main(String[] args) {
        OverloadMethod_2 over = new OverloadMethod_2();
        over.f1();
        over.f1("aaa");
        over.f1(10);
        over.f1(10,"aaa");
        over.f1("aaa", 10);
    }

    public void f1() {
        System.out.println("这是一个没有参数的方法");
    }

    /*
        可以看到被注释的方法返回值时String类型，编译器会报错，因为方法的返回值不能区分重载，只有参数列表可以
    public String f1() {
        System.out.println("方法的返回值不能区分重载");
    }
    */

    public void f1(int i) {
        System.out.println("这是一个带有int类型参数的方法"+i);
    }

    public void f1(String s) {
        System.out.println("这是一个带有String类型参数的方法"+s);
    }

    public void f1(String s, int i) {
        System.out.println("这是一个带有两个参数的方法，顺序是String:"+s+"---int:"+i);
    }

    public void f1(int i, String s) {
        System.out.println("这是一个带有两个参数的方法，顺序是int :"+i+"---String:"+s);
    }


}
