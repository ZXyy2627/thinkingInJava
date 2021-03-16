package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 两个线程调用同一个对象的一个同步方法和一个非同步方法
 *
 * 如果两个线程执行方法A和方法B 还是同步的话就说明锁的是方法，而不是对象  如果是异步的话就说名锁的不是方法或一段代码
 *
 * 从打印结果可以看到，两个线程是异步执行的，说明锁的是对象而不是方法
 */
public class SynchronizedMethodLockObject_6 {
    public static void main(String[] args) {
        MyObject6 myObject6 = new MyObject6();
        ThreadA6 a6 = new ThreadA6(myObject6);
        a6.start();
        ThreadB6 b6 = new ThreadB6(myObject6);
        b6.start();
    }
}

class MyObject6{
    synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time = "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            System.out.println("begin methodB threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA6 extends Thread{
    private MyObject6 myObject6;

    public ThreadA6(MyObject6 myObject6) {
        this.myObject6 = myObject6;
    }

    @Override
    public void run() {
        myObject6.methodA();
    }
}

class ThreadB6 extends Thread {
    private MyObject6 myObject6;

    public ThreadB6(MyObject6 myObject6) {
        this.myObject6 = myObject6;
    }

    @Override
    public void run() {
        myObject6.methodB();
    }
}
