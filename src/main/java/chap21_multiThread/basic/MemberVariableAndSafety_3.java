package chap21_multiThread.basic;

/**
 * 但是实例变量在多线程操作的时候不是线程安全的
 *
 * 出现过两次count=41,从打印结果可以得到结论，多线程操作成员变量的时候不是线程安全的
 */
public class MemberVariableAndSafety_3 {
    public static void main(String[] args) {
        MyObject3 myObject3 = new MyObject3();
        ThreadA3 a3 = new ThreadA3(myObject3);
        a3.setName("A3");
        a3.start();
        ThreadB3 b3 = new ThreadB3(myObject3);
        b3.setName("B3");
        b3.start();
    }
}

class MyObject3{
    private int count = 50;

    public void calcCount(){
        while(count>0){
            count--;
            System.out.println("Thread " +Thread.currentThread().getName() +"calculate count,count = " +count);
        }
    }
}

class ThreadA3 extends Thread {
    private MyObject3 myObject3;

    public ThreadA3(MyObject3 myObject3) {
        super();
        this.myObject3 = myObject3;
    }

    @Override
    public void run() {
        super.run();
        myObject3.calcCount();
    }
}

class ThreadB3 extends Thread {
    private MyObject3 myObject3;

    public ThreadB3(MyObject3 myObject3) {
        super();
        this.myObject3 = myObject3;
    }

    @Override
    public void run() {
        super.run();
        myObject3.calcCount();
    }
}


