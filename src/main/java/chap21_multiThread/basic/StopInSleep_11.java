package chap21_multiThread.basic;

/**
 * 在沉睡中停止线程
 * 线程执行sleep方法时，调用interrupt方法 使线程停止
 */
public class StopInSleep_11 {
    public static void main(String[] args) {
        try {
            ThreadA11 t11 = new ThreadA11();
            t11.start();
            Thread.sleep(200);
            t11.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA11 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("ThreadName = " +Thread.currentThread().getName()+"----i---"+i);
            }
            Thread.sleep(3000);
            System.out.println("线程停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
