package chap21_multiThread.objectAndVariableConcurrentAccess;

import com.sun.istack.internal.NotNull;

/**
 * 验证多个线程调用同一个对象x的同步方法是同步效果的
 *
 * 从打印结果可以看到，A B两个线程呈同步效果，原因 A线程是对象X的同步方法，持有的锁是对象X
 * 而B线程是同步代码块，持有的锁也是对象X，所以这两个线程呈现同步效果
 */
public class MultiThreadTransferSameObjectSynMethod_24 {
    public static void main(String[] args) {
        MyObject24 myObject24 = new MyObject24();
        Service24 service24 = new Service24();

        ThreadA24 a24 = new ThreadA24(myObject24, service24);
        a24.setName("A");
        a24.start();

        ThreadB24 b24 = new ThreadB24(myObject24);
        b24.setName("B");
        b24.start();
    }
}

class MyObject24{
    synchronized public void speedPrintString(){
        try {
            System.out.println("threadName = "+Thread.currentThread().getName()
                    +" ____get lock time = " +System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("threadName = "+Thread.currentThread().getName()
                    +" release lock time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Service24{
    public void testMethod(MyObject24 myObject24){
        synchronized (myObject24) {
            try {
                System.out.println("testMethod ____getLock time = "
                        +System.currentTimeMillis() + "run ThreadName = "
                        +Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("testMethod releaseLock time = "
                        +System.currentTimeMillis() + "run ThreadName = "
                        +Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA24 extends Thread{
    private MyObject24 myObject24;
    private Service24 service24;

    public ThreadA24(MyObject24 myObject24, Service24 service24) {
        this.myObject24 = myObject24;
        this.service24 = service24;
    }

    @Override
    public void run() {
        service24.testMethod(myObject24);
    }
}

class ThreadB24 extends Thread {
    private MyObject24 myObject24 ;

    public ThreadB24(MyObject24 myObject24) {
        this.myObject24 = myObject24;
    }

    @Override
    public void run() {
        myObject24.speedPrintString();
    }
}
