package chap21_multiThread.basic;

/**
 * 什么是守护线程？
 * 守护线程就是 会一直守护着其他所有线程 一旦所有其他的线程都执行完毕任务停止了，那么守护线程也会随之销毁
 * 但是如果还有任何一个线程没有被销毁，那么守护线程就会伴随着一起存在
 *
 * 从打印结果可以看到  线程d设置为守护线程  打印到i=5时，main线程结束了，守护线程也随之结束了
 */
public class DaemonThread_18 {
    public static void main(String[] args) {
        try {
            MyDaemonThread d = new MyDaemonThread();
            d.setDaemon(true);
            d.start();
            Thread.sleep(5000);
            System.out.println("我离开了,d线程也不再打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyDaemonThread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i= " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}