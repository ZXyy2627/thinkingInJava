package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 任意对象作为对象监视器(锁)
 *
 * 使用String类型作为synchronized(非this)作为对象监视器
 *
 * 可以看到使用任意对象，只要synchronized(非this对象x)中对象x是一个对象，线程也是同步执行的
 * 但是如果对象x不一样，那么线程就不是同步执行的
 *
 * 把代码赋值一份，验证如果不是同一个对象，那么多线程调用时时异步的
 */
public class AnyObjectAsLock_18 {
    public static void main(String[] args) {
        Service18 service18 = new Service18();
        ThreadA18 a18 = new ThreadA18(service18);
        a18.setName("A");
        a18.start();
        ThreadB18 b18 = new ThreadB18(service18);
        b18.setName("B");
        b18.start();
    }
}

class Service18 {
    private String username;
    private String password;

    private String anyString = new String();

    public void setUsernameAndPassword(String username,String password) {
        try {
            synchronized (anyString) {
                System.out.println("线程的名称为：" + Thread.currentThread().getName()
                        + " 在 " + System.currentTimeMillis() + "进入同步代码块");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + " 在 " + System.currentTimeMillis() + "离开同步代码块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA18 extends Thread {
    private Service18 service18;

    public ThreadA18(Service18 service18) {
        this.service18 = service18;
    }

    @Override
    public void run() {
        service18.setUsernameAndPassword("a","aa");
    }
}

class ThreadB18 extends Thread {
    private Service18 service18;

    public ThreadB18(Service18 service18) {
        this.service18 = service18;
    }

    @Override
    public void run() {
        service18.setUsernameAndPassword("b","bb");
    }
}
