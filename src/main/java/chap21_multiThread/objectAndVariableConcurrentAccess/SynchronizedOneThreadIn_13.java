package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 接上：因为同步方法有弊端，那么如何解决这个弊端呢？
 * 使用同步代码块可以解决。
 *
 * 如何使用同步代码块?
 *
 * 首先介绍synchronized(this)的使用方式 当两个线程并发访问同一个对象
 * object中的synchronized(this)代码块时，呈同步效果
 *
 * 从打印结果可以看到，两个线程也是同步执行的，同步代码块也具有同步效果
 */
public class SynchronizedOneThreadIn_13 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA13 a13 = new ThreadA13(service);
        a13.start();
        ThreadB13 b13 = new ThreadB13(service);
        b13.start();
    }
}

class ObjectService {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time = " +System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA13 extends Thread {
    private ObjectService objectService;

    public ThreadA13(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod();
    }
}

class ThreadB13 extends Thread {
    private ObjectService objectService;

    public ThreadB13(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod();
    }
}
