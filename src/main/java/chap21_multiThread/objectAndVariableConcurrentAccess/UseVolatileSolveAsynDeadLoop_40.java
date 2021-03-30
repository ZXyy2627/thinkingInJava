package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 使用volatile关键字解决异步死循环
 *
 * volatile 关键字的作用是使某个线程的私有变量，在所有线程间可见
 *
 * 第一次不加volatile关键字可以看到，线程a49还是没有停止，并且他会main线程使异步的效果，
 * 如何解决呢？就是在变量上加上volatile关键字，让所有线程都可以看到volatile关键字
 *
 * 第二次打印结果可以看到，线程a49停止了，volatile关键字的作用就是让变量在线程间可见
 * 并且让线程强制从公共堆栈中取值，而不是从线程的私有堆栈中取值
 *
 *
 * volatile关键字和synchronized关键字的区别：
 *  1.volatile关键字使让变量在线程间可见，synchronized关键字是让线程同步
 *  2.volatile只能修饰变量，synchronized关键字可以修饰方法以及代码块
 *  3.volatile是轻量级的，效率高，synchronized在执行效率上随着JDK版本更新，已经提升很多了
 *  4.volatile保证数据的可见性，但是不保证原子性，synchronized保证原子性，但是不保证可见性
 */
public class UseVolatileSolveAsynDeadLoop_40 {
    public static void main(String[] args) throws InterruptedException {
        PrintString40 a40 = new PrintString40();
        a40.start();
        Thread.sleep(1000);
        a40.setRunning(false);
        System.out.println("已经赋值为false了");
    }
}

class PrintString40 extends Thread{
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run方法了");
        while (isRunning == true) {

        }
        System.out.println("线程被停止了");
    }
}
