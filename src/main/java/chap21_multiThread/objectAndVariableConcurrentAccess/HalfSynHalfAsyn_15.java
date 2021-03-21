package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 一半同步一半异步
 *
 * 同步代码块解决同步方法的弊端就是：
 * 在同步代码块内部的代码是同步执行的，不在同步代码块内部的代码就是异步执行的
 *
 * 验证一半同步一半异步
 */
public class HalfSynHalfAsyn_15 {
    public static void main(String[] args) {
        Task15 task15 = new Task15();
        ThreadA15 a15 = new ThreadA15(task15);
        a15.setName("A15");
        a15.start();
        ThreadB15 b15 = new ThreadB15(task15);
        b15.setName("B15");
        b15.start();
    }
}

class Task15{
    public void doLongTimeTask(){
        for (int i = 0; i < 100; i++) {
            System.out.println("noSynchronized threadName = " +
                    Thread.currentThread().getName()+" i = " +(i+1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = "
                    +Thread.currentThread().getName()+" i = " +(i+1));
            }
        }
    }
}
class ThreadA15 extends Thread{
    private Task15 task15;

    public ThreadA15(Task15 task15) {
        this.task15 = task15;
    }

    @Override
    public void run() {
        task15.doLongTimeTask();
    }
}

class ThreadB15 extends Thread{
    private Task15 task15;

    public ThreadB15(Task15 task15) {
        this.task15 = task15;
    }

    @Override
    public void run() {
        task15.doLongTimeTask();
    }
}
