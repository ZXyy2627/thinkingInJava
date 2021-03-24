package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 *  同步方法会有无限等待，容易造成死循环问题
 *
 *  从打印结果可以看到，当methodA begin 进入循环后，无法退出，不断的在循环，线程B根本无法执行
 *  解决这个问题的办法是使用同步代码块，并且使用不同的锁
 *
 *  修改代码,从打印结果可以看到，同步代码块使用不同的锁对象解决了同步方法无限等待的问题
 *  即两个线程持有不同的锁，即可让线程异步执行
 *
 *
 */
public class SynBlockSolveSynMethodDeadLoop_31 {
    public static void main(String[] args) {
        Service31 service31 = new Service31();
        ThreadA31 a31 = new ThreadA31(service31);
        a31.start();
        ThreadB31 b31 = new ThreadB31(service31);
        b31.start();
    }
}

class Service31{
    Object object1 = new Object();
    Object object2 = new Object();
    public void methodA(){
        synchronized (object1){
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun) {

            }
            System.out.println("methodA end");
        }

    }

    public void methodB() {
        synchronized (object2) {
            System.out.println("methodB begin");
            System.out.println("methodB end");
        }
    }
    /*synchronized public void methodA() {
        System.out.println("methodA begin");
        boolean isContinueRun = true;
        while(isContinueRun){

        }
        System.out.println("methodA end");
    }

    synchronized public void methodB() {
        System.out.println("methodB begin");
        System.out.println("methodB end");
    }*/
}

class ThreadA31 extends Thread{
    private Service31 service31;

    public ThreadA31(Service31 service31) {
        this.service31 = service31;
    }

    @Override
    public void run() {
        service31.methodA();
    }
}

class ThreadB31 extends Thread{
    private Service31 service31;

    public ThreadB31(Service31 service31) {
        this.service31 = service31;
    }

    @Override
    public void run() {
        service31.methodB();
    }
}

