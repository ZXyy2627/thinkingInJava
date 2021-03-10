package chap21_multiThread.basic;

/**
 * 停止线程的三种方式:
 * 1.抛异常停止线程
 * 2.在沉睡中停止线程
 * 3.使用stop方法暴力停止线程
 *
 * 此例使用抛异常法停止线程 ，可以看到 最后一句打印语句并没有打印  说明线程已经停止了
 * 结论：使用抛异常的方法可以停止线程
 */
public class ThrowExceptionStopThread_10 {
    public static void main(String[] args) {
        ThreadA10 t10 = new ThreadA10();
        t10.start();
    }
}

class ThreadA10 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程正在执行"+i);
        }
        //使用抛异常的方法停止线程
        int count = Integer.parseInt("aaa");
        System.out.println("线程还在运行");
    }
}
