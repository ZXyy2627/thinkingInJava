package chap21_multiThread.basic;

import java.util.Objects;

/**
 * 暂停线程  使用suspend方法暂停
 * 使用resume()方法恢复线程
 *
 * suspend()方法不会释放锁 会独占锁
 */
public class SuspendThread_13 {
    public static void main(String[] args) {
        try {
            Thread13 t13 = new Thread13();
            t13.start();
            Thread.sleep(2000);
            t13.suspend();
            System.out.println("A = " +System.currentTimeMillis()+" i = " +t13.getI());
            Thread.sleep(2000);
            System.out.println("A = " +System.currentTimeMillis()+" i = " +t13.getI());
            t13.resume();
            Thread.sleep(2000);
            t13.suspend();
            System.out.println("B = " +System.currentTimeMillis()+" i = " +t13.getI());
            Thread.sleep(2000);
            System.out.println("B = " +System.currentTimeMillis()+" i = " +t13.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread13 extends Thread {
    private long i;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
