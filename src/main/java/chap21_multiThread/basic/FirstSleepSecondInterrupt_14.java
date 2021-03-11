package chap21_multiThread.basic;

/**
 * 先睡眠后打断
 */
public class FirstSleepSecondInterrupt_14 {
    public static void main(String[] args) {
        try {
            MyThread14 t14 = new MyThread14();
            t14.start();
            Thread.sleep(100);
            t14.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch ");
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}

class MyThread14 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(2000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("进入catch ,线程是否处于中断状态" +this.isInterrupted());
            e.printStackTrace();
        }
    }
}
