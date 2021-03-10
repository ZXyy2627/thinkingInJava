package chap21_multiThread.basic;

/**
 * interrupt()方法无法停止线程，只是给线程打上了一个可以停止的标记
 *
 * 从打印结果可以看到，线程并没有停止，而是执行完了run方法
 * 就是因为interrupt()方法只是给线程一个停止的标记  并没有真正的停止线程
 *
 * 还有一点需要注意 ：
 *  interrupt()方法给线程打上停止标记 ，当第二次调用interrupt()方法的时候，会将这个标记擦除
 *    类似于负负得正的道理
 */
public class InterruptThread_8 {
    public static void main(String[] args) {
        Thread8 t8 = new Thread8();
        t8.start();
        t8.interrupt();
    }
}

class Thread8 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("ThreadName = " +Thread.currentThread().getName()
                + " i = " +(i+1));
        }
    }
}
