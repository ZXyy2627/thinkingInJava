package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明线程锁的是对象，而不是一段代码或方法
 * 如何证明线程锁的是对象，而不是方法
 * 首先证明在线程调用同一个对象的非同步方法时，是异步的
 * 然后再证明线程调用同一个对象的同步方法是同步的 这样两个实验可以证明 只有在出现共享操作的时候才需要同步
 *
 * 另外再添加一个非同步方法  如果两个线程分别调用非同步方法 和同步方法 是同步执行 ，那么就证明线程持有的锁是方法
 * 如果是异步的那么就证明线程持有的锁是对象
 */
public class SynchronizedMethodLockObject_4 {
    public static void main(String[] args) {
        //从打印结果可以看到 两个线程是异步执行的
        MyObject4 myObject4 = new MyObject4();
        ThreadA4 a4 = new ThreadA4(myObject4);
        a4.start();
        ThreadB4 b4 = new ThreadB4(myObject4);
        b4.start();
    }
}

class MyObject4 {
    public void methodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA4 extends Thread {
    private MyObject4 myObject4;

    public ThreadA4(MyObject4 myObject4) {
        this.myObject4 = myObject4;
    }

    @Override
    public void run() {
        myObject4.methodA();
    }
}

class ThreadB4 extends Thread {
    private MyObject4 myObject4;

    public ThreadB4(MyObject4 myObject4) {
        this.myObject4 = myObject4;
    }

    @Override
    public void run() {
        myObject4.methodA();
    }
}
