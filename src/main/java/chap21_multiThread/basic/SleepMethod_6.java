package chap21_multiThread.basic;

/**
 * sleep(lont time);
 * 让当前线程沉睡time毫秒
 * 会抛出异常
 */
public class SleepMethod_6 {
    public static void main(String[] args) {
        System.out.println("main 开始");
        Thread6 t6 = new Thread6();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t6.start();
        System.out.println("main ---end");
    }
}

class Thread6 extends Thread{
    @Override
    public void run() {
        System.out.println("t6 begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t6 end");
    }
}
