package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 使用多线程技术解决同步死循环
 *
 * 从打印结果可以看到，使用多线程技术解决了死循环的问题
 */
public class UseMultiThreadSolveDeadLoop_39 {
    public static void main(String[] args) throws InterruptedException {
        PrintString39 printString39 = new PrintString39();
        new Thread(printString39).start();
        Thread.sleep(2000);
        System.out.println("我要停止它 ,threadName = "+Thread.currentThread().getName());
        printString39.setContinuePrint(false);

    }
}

class PrintString39 implements  Runnable{
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod(){
        try {
            while(isContinuePrint == true){
                System.out.println("run printString method  threadName = "
                        + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
