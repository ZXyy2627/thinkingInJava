package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 不同线程调用同一个类的静态同步方法也呈现同步效果
 */
public class SynStaticMethod_26 {
    public static void main(String[] args) {
        Service26 service26 = new Service26();
        ThreadA26 a26 = new ThreadA26(service26);
        a26.setName("A");
        a26.start();

        ThreadB26 b26 = new ThreadB26(service26);
        b26.setName("B");
        b26.start();
    }
}

class Service26{
    synchronized public static void testMethod1() {
        try {
            System.out.println("线程名称为："+Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + "进入方法testMethod1");
            Thread.sleep(3000);
            System.out.println("线程名称为："+Thread.currentThread().getName()
                    + " 在 " + System.currentTimeMillis() + "离开方法testMethod1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void testMethod2() {
        System.out.println("线程名称为："+Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + "进入方法testMethod1");
        System.out.println("线程名称为："+Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + "离开方法testMethod1");
    }
}


class ThreadA26 extends Thread {
    private Service26 service26;

    public ThreadA26(Service26 service26) {
        this.service26 = service26;
    }

    @Override
    public void run() {
        Service26.testMethod1();
    }
}

class ThreadB26 extends Thread {
    private Service26 service26;

    public ThreadB26(Service26 service26) {
        this.service26 = service26;
    }

    @Override
    public void run() {
        Service26.testMethod2();
    }
}