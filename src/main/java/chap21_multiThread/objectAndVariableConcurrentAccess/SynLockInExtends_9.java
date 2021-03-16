package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明：在继承环境中，也支持锁冲入
 *
 * 如何证明？
 * 一个父类，包含一个同步方法，在一个子类的同步方法中调用父类的同步方法
 *
 */
public class SynLockInExtends_9 {
    public static void main(String[] args) {
        ThreadA9 a9 = new ThreadA9();
        a9.start();
    }
}

class Main {
    public int i = 10;

    synchronized public void operateMainMethod() {
        try {
            i--;
            System.out.println("Main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub extends Main {
    synchronized public void operateSubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("Sub print i = " + i);
                Thread.sleep(100);
                this.operateMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA9 extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateSubMethod();
    }
}


