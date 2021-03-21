package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明synchronized(this)同步代码块的锁是当前对象
 *
 * 如何验证，我们之前验证过同步方法的锁是当前对象，只需看看synchronized(this)是否与同步方法同步即可
 *
 * 从打印结果可以看到，两个线程是同步的，证明synchronized(this)和synchronized同步方法是同一个锁
 * 也就是说synchronized(this)的锁也就是当前对象
 */
public class SynchronizedThisLockIsCurrentObject_17 {
    public static void main(String[] args) {
        Service17 service17 = new Service17();
        ThreadA17 a17 = new ThreadA17(service17);
        a17.setName("A");
        a17.start();
        ThreadB17 b17 = new ThreadB17(service17);
        b17.setName("B");
        b17.start();
    }
}

class Service17 {
    public void methodA() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadName = " +Thread.currentThread().getName()
                    + " i = " +i);
            }
        }
    }

    public synchronized void methodB() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadName = " +Thread.currentThread().getName()
                    + " i = "+i);
        }
    }
}

class ThreadA17 extends Thread {
    private Service17 service17;

    public ThreadA17(Service17 service17) {
        this.service17 = service17;
    }

    @Override
    public void run() {
        service17.methodA();
    }
}

class ThreadB17 extends Thread {
    private Service17 service17;

    public ThreadB17(Service17 service17) {
        this.service17 = service17;
    }

    @Override
    public void run() {
        service17.methodB();
    }
}