package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 从打印结果可以到 持有同一个对象的时候，调用同步方法  两个线程是同步执行的
 */
public class SynchronizedMethodLockObject_5 {
    public static void main(String[] args) {
        MyObject5 myObject5 = new MyObject5();
        ThreadA5 a5 = new ThreadA5(myObject5);
        a5.start();
        ThreadB5 b5 = new ThreadB5(myObject5);
        b5.start();
    }
}

class MyObject5 {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA5 extends Thread {
    private MyObject5 myObject5;

    public ThreadA5(MyObject5 myObject5) {
        this.myObject5 = myObject5;
    }

    @Override
    public void run() {
        myObject5.methodA();
    }
}

class ThreadB5 extends Thread {
    private MyObject5 myObject5;

    public ThreadB5(MyObject5 myObject5) {
        this.myObject5 = myObject5;
    }

    @Override
    public void run() {
        myObject5.methodA();
    }
}
