package chap21_multiThread.basic;

/**
 * this.interrupted()判断当前线程是否已经中断
 * this.isInterrupted()  判断线程是否已经中断
 */
public class JudgeWhetherStop_9 {
    public static void main(String[] args) {
        try {
            Thread9 t9 = new Thread9();
            t9.start();
            Thread.sleep(2000);
            System.out.println("线程"+Thread.currentThread().getName()+"是否已经停止"+Thread.currentThread().isInterrupted());
            t9.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class Thread9 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("ThreadName = " +Thread.currentThread().getName() +"---i---"+ (i));
        }
        System.out.println("线程"+Thread.currentThread().getName()+"是否已经停止"+Thread.currentThread().isInterrupted());
    }
}

