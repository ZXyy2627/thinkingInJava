package chap21_multiThread.basic;

/**
 * 线程具有优先级 优先级的大小范围 为1-10  超出这个范围会抛出异常
 *
 * 默认优先级为5
 *
 * 优先级具有继承性
 *
 * 从大到小  优先级越高 获得CPU执行权的概率越大 ，但是不一定是优先级越高的线程先执行完
 *
 * 优先级越高的线程一般都是大部分先执行完，但是不代表是全部执行完
 *
 *
 */
public class PriorityOfThread_17 {
    public static void main(String[] args) {
        Thread17 t17 = new Thread17();
        t17.start();
    }
}

class Thread17 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread's priority = " + this.getPriority());
        MyThread17B t17b = new MyThread17B();
        t17b.start();
    }
}

class MyThread17B extends Thread {
    @Override
    public void run() {
        System.out.println("Thread's priority = " + this.getPriority());
    }
}
