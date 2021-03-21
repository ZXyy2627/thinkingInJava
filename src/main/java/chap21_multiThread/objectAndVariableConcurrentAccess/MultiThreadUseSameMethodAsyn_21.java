package chap21_multiThread.objectAndVariableConcurrentAccess;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个线程调用同一个方法是随机的
 *
 * 从打印结果可以看到，多线程调用同一个方法的随机性  是异步的
 * 在这种情况下，当线程A或线程B出现条件判断时，容易出现脏读现象
 */
public class MultiThreadUseSameMethodAsyn_21 {
    public static void main(String[] args) {
        Service21 service21 = new Service21();
        ThreadA21 a21 = new ThreadA21(service21);
        a21.setName("A*****");
        a21.start();
        ThreadB21 b21 = new ThreadB21(service21);
        b21.setName("B=====");
        b21.start();
    }
}

class Service21 {
    private List list = new ArrayList();

    synchronized public void add(String username) {
        System.out.println("ThreadName = " +Thread.currentThread().getName()
            +"执行了add方法");
        list.add(username);
        System.out.println("ThreadName = " +Thread.currentThread().getName()
            +"退出了add方法");
    }

    synchronized public int getSize() {
        System.out.println("ThreadName = " + Thread.currentThread().getName()+
            "执行了getSize方法");
        int sizeValue = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName()+
                "退出了getSize方法");
        return sizeValue;
    }
}

class ThreadA21 extends Thread {
    private Service21 service21;

    public ThreadA21(Service21 service21) {
        this.service21 = service21;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            service21.add("threadA" + (i+1));
        }
    }
}

class ThreadB21 extends Thread {
    private Service21 service21;

    public ThreadB21(Service21 service21) {
        this.service21 = service21;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            service21.add("threadB"+(i+1));
        }
    }
}
