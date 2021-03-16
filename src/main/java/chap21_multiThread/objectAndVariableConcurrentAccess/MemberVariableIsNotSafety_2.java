package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 类中的成员变量不是线程安全的
 *
 * 从打印结果可以看到，成员变量num的值不是预想的 说明发生了线程安全问题
 *
 * 结论：类中的成员变量不是线程安全的
 *
 * 如果把HasSelfPrivateNum2中的addI方法加上synchronized关键字修饰，那么就可以解决线程安全问题了
 */
public class MemberVariableIsNotSafety_2 {
    public static void main(String[] args) {
        HasSelfPrivateNum2 numRef = new HasSelfPrivateNum2();
        ThreadA2 a2 = new ThreadA2(numRef);
        a2.start();
        ThreadB2 b2 = new ThreadB2(numRef);
        b2.start();
    }
}

class HasSelfPrivateNum2{
    private int num = 10;

    //public void addI(String username) {
    synchronized public void addI(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(1000);
            }else{
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + "num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA2 extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadA2(HasSelfPrivateNum2 numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("a");
    }
}

class ThreadB2 extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadB2(HasSelfPrivateNum2 numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
