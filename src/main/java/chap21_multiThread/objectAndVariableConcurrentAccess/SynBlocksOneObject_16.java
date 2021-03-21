package chap21_multiThread.objectAndVariableConcurrentAccess;

import java.net.ServerSocket;

/**
 * 验证synchronized(){}之间的同步性
 *
 * 多个同步代码块之间只要使用的锁相同那么就具有同步性
 *
 * 从打印结果可以看到，两个线程是同步的，而不是异步的 因为使用同步代码块的锁都是this，
 * 并且这个this代表着当前service16这个对象，也就是说两个同步代码块持有相同的锁
 */
public class SynBlocksOneObject_16 {
    public static void main(String[] args) {
        Service16 service16 = new Service16();
        ThreadA16 a16 = new ThreadA16(service16);
        a16.setName("A");
        a16.start();
        ThreadB16 b16 = new ThreadB16(service16);
        b16.setName("B");
        b16.start();
    }
}

class Service16 {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("methodA begin time = " +System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("methodA end time = "+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("methodB begin time = "+System.currentTimeMillis());
            System.out.println("methodB end time = "+System.currentTimeMillis());
        }
    }
}

class ThreadA16 extends Thread {
    private Service16 service16;

    public ThreadA16(Service16 service16) {
        this.service16 = service16;
    }

    @Override
    public void run() {
        service16.serviceMethodA();
    }
}

class ThreadB16 extends Thread {
    private Service16 service16;

    public ThreadB16(Service16 service16) {
        this.service16 = service16;
    }

    @Override
    public void run() {
        service16.serviceMethodB();
    }
}
