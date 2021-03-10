package chap21_multiThread.basic;

/**
 * isAlive()方法判断当前线程是否存活  返回true / false   表示当前线程是否存活
 */
public class IsAliveMethod_5 {
    public static void main(String[] args) {
        MyThread5 t5 = new MyThread5();
        t5.start();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread5 extends Thread {
    public MyThread5() {
        System.out.println("执行构造器的线程是："+Thread.currentThread().getName()
                + "这个线程还存活着吗？" + Thread.currentThread().isAlive());
    }
    @Override
    public void run() {
        System.out.println("执行run方法的线程是："+Thread.currentThread().getName()
                + "这个线程还存活着吗？"+Thread.currentThread().isAlive());
    }
}
