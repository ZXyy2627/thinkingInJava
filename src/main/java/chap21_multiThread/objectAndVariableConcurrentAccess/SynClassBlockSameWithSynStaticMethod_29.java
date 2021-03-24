package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明静态同步方法与synchronized(class){}效果是一样的
 *
 * 从打印结果可以看到，线程A和线程B呈同步效果
 * 说明：synchronized(class){} 和synchronized static method是一样的效果
 */
public class SynClassBlockSameWithSynStaticMethod_29 {
    public static void main(String[] args) {
        Service29 service29 = new Service29();
        ThreadA29 a29 = new ThreadA29(service29);
        a29.setName("A");
        a29.start();
        ThreadB29 b29 = new ThreadB29(service29);
        b29.setName("B");
        b29.start();
    }
}

class Service29{
    public void methodA(){
        synchronized (Service29.class) {
            try {
                System.out.println("threadName = "+ Thread.currentThread().getName()
                            + " 在 "+System.currentTimeMillis()+"进入methodA方法");
                Thread.sleep(1000);
                System.out.println("threadName = "+Thread.currentThread().getName()
                            +" 在 "+System.currentTimeMillis()+"进入methodA方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public static void methodB() {
        System.out.println("threadName = "+ Thread.currentThread().getName()
                + " 在 "+System.currentTimeMillis()+"进入methodA方法");
        System.out.println("threadName = "+Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"进入methodA方法");
    }
}

class ThreadA29 extends Thread {
    private Service29 service29;

    public ThreadA29(Service29 service29) {
        this.service29 = service29;
    }

    @Override
    public void run() {
        service29.methodA();
    }
}

class ThreadB29 extends Thread {
    private Service29 service29;

    public ThreadB29(Service29 service29) {
        this.service29 = service29;
    }

    @Override
    public void run() {
        Service29.methodB();
    }
}