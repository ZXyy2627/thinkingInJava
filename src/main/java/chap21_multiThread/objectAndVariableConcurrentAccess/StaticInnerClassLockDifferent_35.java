package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 验证静态内部类使用不同的锁，线程呈异步效果
 *
 * 从打印结果可以看到，即使是在内部中，锁不同，线程也呈异步效果
 */
public class StaticInnerClassLockDifferent_35 {
    public static void main(String[] args) {
        final OutClass35.InnerClass35 innerClass35 = new OutClass35.InnerClass35();
        Thread a35 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass35.method1();
            }
        },"A");
        Thread b35 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass35.method2();
            }
        }, "B");
        a35.start();
        b35.start();
    }
}

class OutClass35{
    static class  InnerClass35{
        public void method1() {
            synchronized ("其他的锁") {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i = " +
                            i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public synchronized void method2(){
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " i = "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
