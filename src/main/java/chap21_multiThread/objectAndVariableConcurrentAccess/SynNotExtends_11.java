package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 证明：同步不具有继承性
 *
 * 如何证明：父类具有同步方法，子类继承同步方法，并在子类中调用父类的同步方法
 * 看子类方法调用和父类方法调用是否同步 如果不同步，则证明同步没有继承性
 *
 * 从打印结果可以看到，子类的method方法是异步执行的，而父类的method方法是同步执行的
 * 说明在继承的时候，synchronized修饰方法时没有继承性 否则子类的method方法也应该同步执行
 */
public class SynNotExtends_11 {
    public static void main(String[] args) {
        Sub11 sub11 = new Sub11();
        ThreadA11 a11 = new ThreadA11(sub11);
        a11.setName("A11");
        a11.start();
        ThreadB11 b11 = new ThreadB11(sub11);
        b11.setName("B11");
        b11.start();
    }
}

class Main11 {
    synchronized public void method(){
        try {
            System.out.println("main begin  = " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("main end = "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub11 extends Main11{
    @Override
    public void method() {
        try {
            System.out.println("sub begin = " +System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("sub end = "+System.currentTimeMillis());
            super.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA11 extends Thread {
    private Sub11 sub11;

    public ThreadA11(Sub11 sub11) {
        this.sub11 = sub11;
    }

    @Override
    public void run() {
        sub11.method();
    }
}

class ThreadB11 extends Thread {
    private Sub11 sub11;

    public ThreadB11(Sub11 sub11) {
        this.sub11 = sub11;
    }

    @Override
    public void run() {
        sub11.method();
    }
}