package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * volatile的非原子性
 *
 * 如何证明？只要证明多个线程操作volatile修饰的变量时，不是同步的即可
 *
 * 从打印结果可以看到，count值打印顺序是乱序，说明volatile关键字不具有原子性
 */
public class VolatileNoAtomicity_41 {
    public static void main(String[] args) {
        Runnable runnable = new Service41();
        Thread[] arr = new Thread[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Thread(runnable);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}

class Service41 implements Runnable{
    private volatile static int count = 0;

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" +count);
    }

    @Override
    public void run() {
        addCount();
    }
}
