package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 多个对象，多个锁
 *
 *从打印结果可以看到，线程是异步执行的 ，说明这两个线程持有的锁是不一样的 上个例子中，两个线程持有的对象
 * 只有一个 ，现在这个例子中两个线程分别对应不同的对象
 * 所以  结论就是 多个对象多个锁
 */
public class TwoObjectTowLock_3 {
    public static void main(String[] args) {
        HasSelfPrivateNum3 numRef1 = new HasSelfPrivateNum3();
        HasSelfPrivateNum3 numRef2 = new HasSelfPrivateNum3();
        ThreadA3 t1 = new ThreadA3(numRef1);
        t1.start();
        ThreadB3 t2 = new ThreadB3(numRef2);
        t2.start();
    }
}

class HasSelfPrivateNum3{
    private int num = 10;

    //public void addI(String username) {
    synchronized public void addI(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(1000);
            }else{
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + "num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA3 extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadA3(HasSelfPrivateNum3 numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("a");
    }
}

class ThreadB3 extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadB3(HasSelfPrivateNum3 numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
