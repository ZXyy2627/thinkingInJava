package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 使用String常量池对象作为synchronized代码块的锁会有问题
 *
 * 从打印结果可以看到，线程A一直在执行，而线程B一直在等待拿到锁，但是始终拿不到锁，无法执行
 *
 * 所以也就是说使用String常量池的对象作为锁会产生问题
 */
public class SynBlockUseStringHasProblem_30 {
    public static void main(String[] args) {
        Service30 service30 = new Service30();
        ThreadA30 a30 = new ThreadA30(service30);
        a30.setName("A");
        a30.start();
        ThreadB30 b30 = new ThreadB30(service30);
        b30.setName("B");
        b30.start();
    }
}

class Service30{
    public void methodA(String param){
        try {
            synchronized (param){
                while (true) {
                    System.out.println("theradName = "+Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA30 extends Thread {
    private Service30 service30;

    public ThreadA30(Service30 service30) {
        this.service30 = service30;
    }

    @Override
    public void run() {
        service30.methodA("AA");
    }
}

class ThreadB30 extends Thread {
    private Service30 service30;

    public ThreadB30(Service30 service30) {
        this.service30 = service30;
    }

    @Override
    public void run() {
        service30.methodA("AA");
    }
}
