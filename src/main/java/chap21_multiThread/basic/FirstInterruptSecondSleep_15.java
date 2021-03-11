package chap21_multiThread.basic;

public class FirstInterruptSecondSleep_15 {
    public static void main(String[] args) {
        try {
            MyThread15 t15 = new MyThread15();
            t15.start();
            Thread.sleep(1);
            t15.interrupt();
            System.out.println("main end");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}

class MyThread15 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run begin");
            for (int i = 0; i < 500000; i++) {
                i++;
            }
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("进入catch， 线程是否中断"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
