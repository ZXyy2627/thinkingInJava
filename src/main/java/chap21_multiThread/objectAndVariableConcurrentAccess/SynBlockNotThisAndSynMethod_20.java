package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 非this的同步代码块和synchronized同步方法是异步运行的
 *
 * 从打印结果看到，确实两个线程是异步执行的
 * 原因：同步代码块需要的锁是非this的对象x,而同步方法的锁是当前对象，也就是this
 * 但是两个线程需要的锁不同，那么就是异步执行了
 */
public class SynBlockNotThisAndSynMethod_20 {
    public static void main(String[] args) {
        Service20 service20 = new Service20();
        ThreadA20 a20 = new ThreadA20(service20);
        a20.setName("A");
        a20.start();
        ThreadB20 b20 = new ThreadB20(service20);
        b20.setName("B");
        b20.start();
    }
}

class Service20 {
    public void methodA(){
        try {
            synchronized ("123"){
                System.out.println("threadName = " +Thread.currentThread().getName() +
                        " 在 " +System.currentTimeMillis() + "进入同步代码块了");
                Thread.sleep(1000);
                System.out.println("threadName = " + Thread.currentThread().getName() +
                        " 在 " + System.currentTimeMillis() +"离开同步代码块了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        System.out.println("threadName = " +Thread.currentThread().getName() +
                " 在 " +System.currentTimeMillis() + "进入同步代码块了");
        System.out.println("threadName = " + Thread.currentThread().getName() +
                " 在 " + System.currentTimeMillis() +"离开同步代码块了");
    }
}

class ThreadA20 extends Thread {
    private Service20 service20;

    public ThreadA20(Service20 service20) {
        this.service20 = service20;
    }

    @Override
    public void run() {
        service20.methodA();
    }
}

class ThreadB20 extends Thread {
    private Service20 service20;

    public ThreadB20(Service20 service20) {
        this.service20 = service20;
    }

    @Override
    public void run() {
        service20.methodB();
    }
}
