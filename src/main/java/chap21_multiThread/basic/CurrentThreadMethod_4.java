package chap21_multiThread.basic;

/**
 * Thread类的静态方法 currentThread()返回当前正在执行的线程对象
 *
 * 从打印结果可以看到：t1对象的构造器是由main线程执行的 run方法是由Thread-0这个线程执行的
 *
 * 所以currentThread()方法返回的是当前正在执行的线程对象
 */
public class CurrentThreadMethod_4 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}

class MyThread extends Thread {
    public MyThread(){
        System.out.println("MyThread类的构造方法正在执行");
        System.out.println("ThreadName = " +Thread.currentThread().getName());
        System.out.println("MyThread类的构造方法执行完毕");
    }

    @Override
    public void run(){
        System.out.println("MyThread的run方法开始执行");
        System.out.println("ThreadName = " + Thread.currentThread().getName());
        System.out.println("MyThread的run方法执行完毕");
    }
}
