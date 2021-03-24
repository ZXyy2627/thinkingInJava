package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明静态同步方法是Class锁，而Class锁是给该类的所有对象起作用
 *
 * 从打印结果可以看到，线程A和线程B是同步效果的，即使有两个Service28对象，
 * 说明静态同步方法是对Class上锁，而不是给对象上锁，而Class锁对该类的所有对象都有作用
 */
public class SynMoreObjectStaticOneLock_28 {
    public static void main(String[] args) {
        Service28 s1 = new Service28();
        Service28 s2 = new Service28();
        ThreadA28 a28 = new ThreadA28(s1);
        a28.setName("A");
        ThreadB28 b28 = new ThreadB28(s2);
        b28.setName("B");
        a28.start();
        b28.start();
    }
}

class Service28{
    synchronized static public void printA() {
        try {
            System.out.println("threadName = "+Thread.currentThread().getName()
                    + " 在 "+System.currentTimeMillis()+"进入printA方法");
            Thread.sleep(1000);
            System.out.println("threadName = "+Thread.currentThread().getName()
                    + " 在 "+System.currentTimeMillis() +"离开printA方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("threadName = "+Thread.currentThread().getName()
                + " 在 "+System.currentTimeMillis()+"进入printB方法");
        System.out.println("threadName = "+Thread.currentThread().getName()
                + " 在 "+System.currentTimeMillis() +"离开printB方法");
    }
}

class ThreadA28 extends Thread {
    private Service28 service28;

    public ThreadA28(Service28 service28) {
        this.service28 = service28;
    }

    @Override
    public void run() {
        Service28.printA();
    }
}

class ThreadB28 extends Thread {
    private Service28 service28;

    public ThreadB28(Service28 service28) {
        this.service28 = service28;
    }

    @Override
    public void run() {
        Service28.printB();
    }
}
