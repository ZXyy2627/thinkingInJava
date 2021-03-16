package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 当抛出异常，线程停止时，锁自动释放
 *
 * 如何证明：启动两个线程，获得同一个对象锁，其中一个线程抛出异常，另一个线程会获得锁继续运行
 */
public class ThrowExceptionLockOut_10 {
    public static void main(String[] args) {
        Service10 service10 = new Service10();
        ThreadA10 a10 = new ThreadA10(service10);
        a10.setName("A10");
        a10.start();
        ThreadB10 b10 = new ThreadB10(service10);
        b10.setName("B10");
        b10.setPriority(8);
        b10.start();
    }
}

class Service10 {
    private int count = 20000;

    public void operate() {
        while(count>0){
            synchronized (this) {
                count--;
                System.out.println(Thread.currentThread().getName()
                        + "执行了方法 count = " +count);
            }
        }
    }
}

class ThreadA10 extends Thread {
    private Service10 service10;

    public ThreadA10(Service10 service10) {
        this.service10 = service10;
    }

    @Override
    public void run() {
        try {
            service10.operate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadB10 extends Thread {
    private Service10 service10;

    public ThreadB10(Service10 service10) {
        this.service10 = service10;
    }

    @Override
    public void run() {
        try {
            synchronized (service10){
                service10.operate();
                int a = Integer.parseInt("a");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
