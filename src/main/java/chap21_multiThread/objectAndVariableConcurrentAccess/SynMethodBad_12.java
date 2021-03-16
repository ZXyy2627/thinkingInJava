package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * synchronized修饰方法有弊端：
 *  弊端就是同步方法是一个长时间的任务时，那么会使程序的效率降低
 *
 *  如何证明 ：让执行同步方法的线程睡3秒，模拟查询组合数据,计算任务执行的时间
 *
 *  从打印结果可以看到，线程A和线程B同步执行任务，每个任务执行3000毫秒左右
 *  整个程序耗时6秒，时间太长  这就是当同步方法执行的任务时间过长的时候，那么只有一个对象锁
 *  第二个线程必须等待第一个线程执行完以后拿到锁才能开始执行任务 这样效率太差
 */
public class SynMethodBad_12 {
    public static void main(String[] args) {
        Task12 task12 = new Task12();
        ThreadA12 a12 = new ThreadA12(task12);
        a12.setName("A12");
        a12.start();
        ThreadB12 b12 = new ThreadB12(task12);
        b12.setName("B12");
        b12.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long begin = CommonUtils.beginTime1;
        if(CommonUtils.beginTime1 > CommonUtils.beginTime2){
            begin = CommonUtils.beginTime2;
        }
        long end = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            end = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + (end - begin));
    }
}

class Task12 {
    private String getData1;
    private String getData2;

    synchronized public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName = "
                        + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName = "
                        + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class ThreadA12 extends Thread {
    private Task12 task12;

    public ThreadA12(Task12 task12) {
        this.task12 = task12;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task12.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

class ThreadB12 extends Thread {
    private Task12 task12;

    public ThreadB12(Task12 task12) {
        this.task12 = task12;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task12.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}