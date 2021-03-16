package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 什么时锁重入？
 * 就是当一个线程得到一个对象锁后，再次请求这个对象锁，它依然会得到该对象锁
 *
 * 可以看到，service1，service2，service3方法都执行了，
 * 说明在同步方法内部还是可以调用同步方法，就证明了在同步方法内部再次请求锁的时候，它还能继续得到这个对象锁
 */
public class SynLockIn_8 {
    public static void main(String[] args) {
        Service8 service8 = new Service8();
        ThreadA8 t8 = new ThreadA8(service8);
        t8.start();
    }
}

class Service8{
    synchronized public void service3(){
        System.out.println("service3执行了");
    }

    synchronized public void service2() {
        System.out.println("service2执行了");
        service3();
    }

    synchronized public void service1() {
        System.out.println("service1执行了");
        service2();
    }
}

class ThreadA8 extends Thread {
    private Service8 service8;

    public ThreadA8(Service8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.service1();
    }
}
