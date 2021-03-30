package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 先来看一个死循环的例子
 *
 * 从打印结果可以看到，main线程根本就没有停止，因为它一直在循环
 * 根本就没有执行后面的代码
 * 这就是死循环，无法从循环中跳出来，也无法改变
 */
public class VolatileAndDeadLoop_38 {
    public static void main(String[] args) {
        PrintString38 printString38 = new PrintString38();
        printString38.printStringMethod();
        System.out.println("我要停止它！stopThread = "+Thread.currentThread().getName());
        printString38.setContinuePrint(false);
    }
}

class PrintString38{
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println(" printStringMethod 正在运行，threadName = "
                    +Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
