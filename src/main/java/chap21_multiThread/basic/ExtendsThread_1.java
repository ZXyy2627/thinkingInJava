package chap21_multiThread.basic;

/**
 * 实现多线程的两种方式
 * 1.继承Thread类，重写run方法
 *
 * 2.实现Runnable接口，重写run方法
 *
 * 这两种方式在效果上是一样的，没有区别 都是创建线程对象的方式
 * 原因是：Java是单继承 在某个类已经继承了它的父类的情况下，还想实现多线程的途径就是实现Runnable接口
 */
public class ExtendsThread_1 {
    public static void main(String[] args) {
        //继承Thread类方式 可以使用Thread类的无参构造器创建线程对象
        Thread1 t1 = new Thread1();
        t1.start();
        //实现Runnable接口的方式 ，使用Thread类的带有参数（Runnable runnable)的构造器
        Runnable run2 = new Thread2();
        Thread t2 = new Thread(run2);
        t2.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        int count = 50;
        while(count>0){
            count--;
            System.out.println("count = " + count);
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run(){
        int count = 50;
        while(count>0){
            count--;
            System.out.println("count = " + count);
        }
    }
}
