package chap21_multiThread.basic;

/**
 * yield()方法  使当前线程放弃CPU执行权，放弃多久不确定  也许刚放弃，线程马上又拿到执行权了
 *
 * 第一次  注释Thread.yield()  执行了6毫秒
 * 第二次  放开注释  执行了3361毫秒
 */
public class YieldMethod_16 {
    public static void main(String[] args) {
        Thread t16 = new Thread(new Runnable() {
            @Override
            public void run() {
                long begin = System.currentTimeMillis();
                System.out.println("run begin");
                int count = 0;
                for (int i = 0; i < 5000000; i++) {
                    Thread.yield();
                    count = count+(i+1);
                }
                long end = System.currentTimeMillis();
                System.out.println("执行了"+(end - begin) +"毫秒");
            }
        });
        t16.start();
    }
}

