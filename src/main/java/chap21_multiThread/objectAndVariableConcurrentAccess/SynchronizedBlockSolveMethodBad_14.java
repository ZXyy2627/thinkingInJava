package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 使用同步代码块解决同步方法的弊端 执行任务时间过长的问题
 *
 * 就是把赋值的数据放到同步代码块中，不需要赋值的数据操作放到同步代码块外
 *
 * 从打印结果可以看到，使用同步代码块部分解决了同步方法的弊端
 */
public class SynchronizedBlockSolveMethodBad_14 {
    public static void main(String[] args) {
        Task14 task14 = new Task14();
        ThreadA14 a14 = new ThreadA14(task14);
        a14.setName("A14");
        a14.start();
        ThreadB14 b14 = new ThreadB14(task14);
        b14.setName("B14");
        b14.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long being = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            being = CommonUtils.beginTime2;
        }
        long end = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            end = CommonUtils.endTime2;
        }

        System.out.println("耗时："+(end-being));
    }
}

class Task14 {
    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务后从远程返回的值1 threadName = "
                    +Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 threadName = "
                    +Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }
            System.out.println("getData1= " + getData1);
            System.out.println("getData2= " + getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA14 extends Thread {
    private Task14 task14;

    public ThreadA14(Task14 task14) {
        this.task14 = task14;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task14.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

class ThreadB14 extends Thread {
    private Task14 task14;

    public ThreadB14(Task14 task14) {
        this.task14 = task14;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task14.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}