package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 当其他线程执行x对象方法里面的synchronized(this)代码块也呈同步效果
 */
public class MultiThreadTransferSameObjectSynBlock_25 {
    public static void main(String[] args) {
        MyObject25 myObject25 = new MyObject25();
        ThreadA25 a25 = new ThreadA25(myObject25);
        a25.setName("A");
        a25.start();
        ThreadB25 b25 = new ThreadB25(myObject25);
        b25.setName("B");
        b25.start();
    }
}

class MyObject25{
    synchronized public void testMethod1() {
        try {
            System.out.println("threadName = " +Thread.currentThread().getName()
                    +" testMethod1 ____getLock time = "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("threadName = " +Thread.currentThread().getName()
                    +" testMethod1 releaseLock time = " +System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testMethod2() {
        synchronized (this) {
            try {
                System.out.println("threadName = " +Thread.currentThread().getName()
                        +" testMethod1 ____getLock time = "+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("threadName = " +Thread.currentThread().getName()
                        +" testMethod1 releaseLock time = " +System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA25 extends Thread {
    private MyObject25 myObject25;

    public ThreadA25(MyObject25 myObject25) {
        this.myObject25 = myObject25;
    }

    @Override
    public void run() {
        myObject25.testMethod1();
    }
}

class ThreadB25 extends Thread {
    private MyObject25 myObject25;

    public ThreadB25(MyObject25 myObject25) {
        this.myObject25 = myObject25;
    }

    @Override
    public void run() {
        myObject25.testMethod2();
    }
}