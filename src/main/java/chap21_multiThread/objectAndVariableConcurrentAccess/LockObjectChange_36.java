package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明锁对象改变了，线程就会异步
 *
 * 从打印结果可以看到，当线程A进入方法后，锁对象改变，我们知道sleep方法不释放锁，而当A线程sleep时，
 * B线程却进来了，原因是锁对象改变了，B线程相当得到了另一个锁对象，也就导致线程是异步的了
 */
public class LockObjectChange_36 {
    public static void main(String[] args) throws InterruptedException {
        Service36 service36 = new Service36();
        Thread a36 = new Thread(new Runnable() {
            @Override
            public void run() {
                service36.testMethod();
            }
        },"A");
        a36.start();
        Thread.sleep(200);
        Thread b36 = new Thread(new Runnable() {
            @Override
            public void run() {
                service36.testMethod();
            }
        },"B");
        b36.start();
    }
}

class Service36 {
    private String lock = "123";

    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println("threadName = " +Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"进入方法了");
                lock ="456";
                Thread.sleep(2000);
                System.out.println("threadName = "+Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"离开方法了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
