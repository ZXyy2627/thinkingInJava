package chap21_multiThread.multiThreadCommunicate;

/**
 * 验证wait方法需要锁，否则会抛异常
 *
 * 从打印结果可以看到，在没有锁的情况下，调用wait方法会抛出异常IllegalMonitorStateException
 *
 * 总结：
 *      1.调用wait方法前，需要对象级别的锁，否则会抛出IllegalMonitorStateException，也就是说wait方法
 *    只能用于同步代码块或者同步方法中。
 *      2.wait方法释放锁
 *      3.如果没有得到锁，会抛出异常
 */
public class WaitNeedLock_3 {
    public static void main(String[] args) {
        try {
            String str = new String("");
            str.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
