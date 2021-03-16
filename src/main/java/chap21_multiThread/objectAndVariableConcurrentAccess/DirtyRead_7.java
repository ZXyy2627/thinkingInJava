package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 什么是脏读？
 * 就是多个线程调用同一个方法，操作成员变量的时候出现了数据交叉的现象
 *
 * 从打印结果可以看到，两个线程在操作成员变量count ，操作的顺序不对的原因就是出现了数据交叉的情况
 */
public class DirtyRead_7 {
    public static void main(String[] args) {
        MyObject7 myObject7 = new MyObject7();
        ThreadA7 a7 = new ThreadA7(myObject7);
        a7.setName("A7");
        a7.start();
        ThreadB7 b7 = new ThreadB7(myObject7);
        b7.setName("B7");
        b7.start();
    }
}

class MyObject7 {
    private int count = 10;

    public void calcCount(){
        while(count>0){
            count--;
            System.out.println("threadName = " +Thread.currentThread().getName()
                +" 正在操作count = " + count);
        }
    }
}

class ThreadA7 extends Thread {
    private MyObject7 myObject7;

    public ThreadA7(MyObject7 myObject7) {
        this.myObject7 = myObject7;
    }

    @Override
    public void run() {
        myObject7.calcCount();
    }
}

class ThreadB7 extends Thread {
    private MyObject7 myObject7;

    public ThreadB7(MyObject7 myObject7) {
        this.myObject7 = myObject7;
    }

    @Override
    public void run() {
        myObject7.calcCount();
    }
}