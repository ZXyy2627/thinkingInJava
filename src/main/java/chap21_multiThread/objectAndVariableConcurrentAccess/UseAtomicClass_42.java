package chap21_multiThread.objectAndVariableConcurrentAccess;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类进行i++操作
 *
 * 从打印结果可以看到，每个线程增加10000次，启动5个线程，最后count的值是50000
 */
public class UseAtomicClass_42 {
    public static void main(String[] args) {
        AddCountThread addCountThread = new AddCountThread();
        Thread a1 = new Thread(addCountThread);
        a1.start();
        Thread a2 = new Thread(addCountThread);
        a2.start();
        Thread a3 = new Thread(addCountThread);
        a3.start();
        Thread a4 = new Thread(addCountThread);
        a4.start();
        Thread a5 = new Thread(addCountThread);
        a5.start();
    }
}

class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
