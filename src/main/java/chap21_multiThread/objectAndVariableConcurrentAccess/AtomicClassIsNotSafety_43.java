package chap21_multiThread.objectAndVariableConcurrentAccess;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 从上一个实验，我们可以知道原子类具有原子性，说明原子类操作变量是线程安全的
 * 但是如果是多次调用原子类的方法就不是线程安全的了，所以即使你使用的是原子类操作数据，但是也要注意线程安全问题
 *
 * 证明：使用原子类并非绝对安全
 * 从打印结果看，count值是乱序打印的，所以可以证明使用原子类也并非绝对的线程安全
 *
 * 修改方法，变成同步方法即可变成线程安全的
 */
public class AtomicClassIsNotSafety_43 {
    public static void main(String[] args) {
        Service43 service43 = new Service43();
        Thread[] arr = new Thread[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(service43);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}

class Service43 extends Thread{
    private static AtomicLong count = new AtomicLong();

    synchronized public static void addNum() {
        System.out.println(Thread.currentThread().getName() +" 加了100后的值是"
                +count.addAndGet(100));
        count.addAndGet(1);
    }

    @Override
    public void run() {
        addNum();
    }
}
