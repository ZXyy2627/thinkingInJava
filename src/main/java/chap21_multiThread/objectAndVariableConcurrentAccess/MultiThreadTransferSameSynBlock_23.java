package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 多线程同时调用同一同步代码块呈同步效果
 */
public class MultiThreadTransferSameSynBlock_23 {
}

class MyObject23{}
class Service23 {
    public void testMethod1(MyObject23 myObject23) {
        synchronized (myObject23) {
            try {
                System.out.println("threadName = " +Thread.currentThread().getName()
                        + "在" +System.currentTimeMillis() +"进入了方法");
                Thread.sleep(1000);
                System.out.println("threadName = " +Thread.currentThread().getName()
                        + "在" +System.currentTimeMillis() +"离开了方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
