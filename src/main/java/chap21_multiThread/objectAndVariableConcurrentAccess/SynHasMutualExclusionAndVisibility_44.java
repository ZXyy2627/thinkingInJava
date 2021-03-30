package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 验证synchronized关键字可以将线程的工作内存中的私有变量和公共内存中的变量同步的功能
 *
 * 可以看到并没有停下来,那么修改代码  在service44类中runMethod加上一个String类型的变量,并在while循环
 * 内加上synchronized代码块
 */
public class SynHasMutualExclusionAndVisibility_44 {
    public static void main(String[] args) throws InterruptedException {
        Service44 service44 = new Service44();
        ThreadA44 a44 = new ThreadA44(service44);
        a44.start();
        Thread.sleep(1000);
        ThreadB44 b44 = new ThreadB44(service44);
        b44.start();
        System.out.println("已经发起了停止命令");
    }
}

class Service44{
    private boolean isContinueRun = true;

    public void runMethod() {
        String anyString = new String("");
        while (isContinueRun == true) {
            synchronized (anyString) {

            }
        }
        System.out.println("停下来了");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}

class ThreadA44 extends Thread {
    private Service44 service44;

    public ThreadA44(Service44 service44) {
        this.service44 = service44;
    }

    @Override
    public void run() {
        service44.runMethod();
    }
}

class ThreadB44 extends Thread {
    private Service44 service44;

    public ThreadB44(Service44 service44) {
        this.service44 = service44;
    }

    @Override
    public void run() {
        service44.stopMethod();
    }
}