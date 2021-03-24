package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 什么是死锁？就是线程A持有锁的时候，还没有释放，线程B又需要这个锁才能执行
 *
 * 从打印结果可以看到，两个线程都只打印了第一句话就不动了，但是程序还在继续运行
 * 原因就是：
 *  线程A先启动开始运行  得到lock1这个锁，然后开始睡眠3秒，这3秒内线程B开始运行拿到第二个锁
 *  也开始睡眠3秒，然后线程A，B都睡眠结束 线程A需要拿到锁lock2,但是这时lock2在线程B手上没有释放
 *  而线程B需要lock1这个锁在线程A 手上还没有释放，这就是死锁
 */
public class DeadLock_32 {
    public static void main(String[] args) {
        try {
            DeadThread t1 = new DeadThread();
            t1.setFlag("a");
            Thread a = new Thread(t1);
            a.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread b = new Thread(t1);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class DeadThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run() {
        if ("a".equals(username)) {
            synchronized (lock1){
                try {
                    System.out.println("username = "+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按lock1 -> lock2代码顺序执行");
                }
            }
        } else if ("b".equals(username)) {
            synchronized (lock2) {
                try {
                    System.out.println("username = "+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2 -> lock1代码顺序执行");
                }
            }
        }
    }
}
