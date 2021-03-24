package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 *  证明synchronized static方法和synchronized方法的锁不同
 *
 *  从打印结果可以看到  线程A和线程B执行的静态同步方法，这两个线程呈同步效果
 *  但是线程C执行的是同步方法 ，与A,B两个线程呈异步效果，说明他们持有的锁不一样
 */
public class SynStaticLockClass_27 {
    public static void main(String[] args) {
        Service27 service27 = new Service27();
        ThreadA27 a27 = new ThreadA27(service27);
        a27.setName("A");
        ThreadB27 b27 = new ThreadB27(service27);
        b27.setName("B");
        ThreadC27 c27 = new ThreadC27(service27);
        c27.setName("C");
        a27.start();
        b27.start();
        c27.start();
    }
}

class Service27{
    synchronized public static void methodA(){
        try {
            System.out.println("threadName = "+ Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis() + " 进入了methodA方法");
            Thread.sleep(3000);
            System.out.println("threadName = "+Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis() +"离开了methodA方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void methodB(){
        try {
            System.out.println("threadName = "+Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis() + " 进入了methodB方法");
            Thread.sleep(1000);
            System.out.println("threadName = " +Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis()+ " 离开了methodB方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodC(){
        System.out.println("threadName = "+Thread.currentThread().getName()+
                " 在 " + System.currentTimeMillis() + "进入了methodC方法");
        System.out.println("threadName = "+Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"离开了methodC方法");
    }
}

class ThreadA27 extends Thread{
    private Service27 service27;

    public ThreadA27(Service27 service27) {
        this.service27 = service27;
    }

    @Override
    public void run() {
        Service27.methodA();
    }
}

class ThreadB27 extends Thread{
    private Service27 service27;

    public ThreadB27(Service27 service27) {
        this.service27 = service27;
    }

    @Override
    public void run() {
        Service27.methodB();
    }
}

class ThreadC27 extends Thread{
    private Service27 service27;

    public ThreadC27(Service27 service27) {
        this.service27 = service27;
    }

    @Override
    public void run() {
        service27.methodC();
    }
}



