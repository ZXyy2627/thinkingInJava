package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 验证任意对象作为监视器不是同一个就是异步的
 *
 * 从打印结果就可以看到，锁不一样，两个线程调用同一个方法时异步执行的
 */
public class AnyObjectAsLockNotOne_19 {
    public static void main(String[] args) {
        Service19 service19 = new Service19();
        ThreadA19 a19 = new ThreadA19(service19);
        a19.setName("A");
        a19.start();
        ThreadB19 b19 = new ThreadB19(service19);
        b19.setName("B");
        b19.start();
    }
}

class Service19{
    private String username;
    private String password;

    public void setUsernameAndPassword(String username,String password) {
        String anyString = new String();
        //把anyString这个对象放到方法内部，意味着每次调用该方法都会创建一个新的对象
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

class ThreadA19 extends Thread {
    private Service19 service19;

    public ThreadA19(Service19 service19) {
        this.service19 = service19;
    }

    @Override
    public void run() {
        service19.setUsernameAndPassword("a","aa");
    }
}

class ThreadB19 extends Thread {
    private Service19 service19;

    public ThreadB19(Service19 service19) {
        this.service19 = service19;
    }

    @Override
    public void run() {
        service19.setUsernameAndPassword("b","bb");
    }
}
