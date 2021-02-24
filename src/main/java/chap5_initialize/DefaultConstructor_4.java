package chap5_initialize;

/**
 * 无参构造器又叫默认构造器
 *
 * 在一个类中，如果没有写任何构造器，那么编译器会帮你创建一个默认的没有参数的构造器  叫默认构造器
 *
 * 如果在该类中，已经写了任何一个带有参数的构造器，那么编译器不会帮你创建默认构造器了
 */
public class DefaultConstructor_4 {
    public static void main(String[] args) {
        Bird  bird = new Bird(); //这是编译器创建的默认构造器初始化的对象

        Bird2 bird2 = new Bird2();

        //Bird3 bird3 = new Bird3();//这里编译器会报错，因为Bird3这个类中有了带参数的构造器，并且没有写无参构造器

        Bird3 bird3 = new Bird3(5);
    }
}
class Bird{
    //这里没有写任何构造器，编译器会创建一个默认构造器
}

class Bird2{
    public Bird2(){
        System.out.println("这是自己写的无参构造器");
    }
}

class Bird3{
    public Bird3(int i){
        System.out.println("这是带参数的构造器");
    }
}
