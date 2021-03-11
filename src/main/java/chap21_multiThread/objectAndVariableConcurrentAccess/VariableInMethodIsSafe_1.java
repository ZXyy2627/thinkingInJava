package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 非线程安全问题 存在于实例变量中
 * 而方法中的变量是线程安全的
 *
 * 从打印结果可以看到  a线程num的值  与 b线程num的值都是我们预想的 并没有出现线程安全问题
 * 所以得出结论 方法中的变量是线程安全的
 */
public class VariableInMethodIsSafe_1 {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA1 a1 = new ThreadA1(numRef);
        a1.start();
        ThreadB1 b1 = new ThreadB1(numRef);
        b1.start();
    }
}
class HasSelfPrivateNum{
    public void addI(String username){
        try {
            int num = 0;
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + "num="+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA1 extends Thread {
    private HasSelfPrivateNum numRef;

    public ThreadA1(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB1 extends Thread {
    private HasSelfPrivateNum numRef;

    public ThreadB1(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}

