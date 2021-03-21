package chap21_multiThread.objectAndVariableConcurrentAccess;

import java.util.ArrayList;
import java.util.List;

/**
 * 证明多个线程调用同一方法容易出现脏读现象，特别时在方法内部存在条件判断的时候
 *
 * 出现脏读的原因就是因为在调用方法时出现了分支条件的判断，两个线程都还没有对list进行操作的时候，
 * 就判断了list的大小为0 ，然后a添加一个，b添加一个 导致出现了不符合预期的执行
 *
 * 如何解决呢 ？加上同步代码块即可 在判断大小的时候加上同步代码块  这里要想使两个线程同步
 * 应该使用对象list作为锁，因为只有list是共享的，并且只有一个  service对象有两个
 */
public class MultiThreadUseSameMethodHasDirtyRead_22 {
    public static void main(String[] args) throws InterruptedException {
        MyList22 list = new MyList22();
        ThreadA22 a22 = new ThreadA22(list);
        a22.setName("A");
        a22.start();
        ThreadB22 b22 = new ThreadB22(list);
        b22.setName("B");
        b22.start();
        Thread.sleep(6000);
        System.out.println("listSize = " + list.getSize());
    }
}

class MyList22 {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}

class Service22 {
    public MyList22 addServiceMethod(MyList22 myList22,String data) {
        synchronized (myList22) {
            if(myList22.getSize() <1){
                try {
                    Thread.sleep(2000);
                    myList22.add(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return myList22;
    }
}

class ThreadA22 extends Thread {
    private MyList22 myList22;

    public ThreadA22(MyList22 myList22) {
        this.myList22 = myList22;
    }

    @Override
    public void run() {
        Service22 service22 = new Service22();
        service22.addServiceMethod(myList22,"A");
    }
}

class ThreadB22 extends Thread {
    private MyList22 myList22;

    public ThreadB22(MyList22 myList22) {
        this.myList22 = myList22;
    }

    @Override
    public void run() {
        Service22 service22 = new Service22();
        service22.addServiceMethod(myList22,"B");
    }
}

