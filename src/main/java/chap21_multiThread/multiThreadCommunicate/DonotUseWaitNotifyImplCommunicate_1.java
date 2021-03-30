package chap21_multiThread.multiThreadCommunicate;

import java.util.ArrayList;
import java.util.List;

/**
 *实验一：不使用wait/notify实现线程间的通信
 */
public class DonotUseWaitNotifyImplCommunicate_1 {
    public static void main(String[] args) {
        MyList1 myList1 = new MyList1();
        ThreadA1 a1 = new ThreadA1(myList1);
        a1.start();
        ThreadB1 b1 = new ThreadB1(myList1);
        b1.start();
    }
}

class MyList1{
    private List<String> list = new ArrayList<String>();
    public void add(){
        list.add("zx");
    }

    public int size() {
        return list.size();
    }
}

class ThreadA1 extends Thread{
    private MyList1 myList1;

    public ThreadA1(MyList1 myList1) {
        this.myList1 = myList1;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                myList1.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB1 extends Thread{
    private MyList1 myList1;

    public ThreadB1(MyList1 myList1) {
        this.myList1 = myList1;
    }

    @Override
    public void run() {
        try {
            while(true){
                if (myList1.size() == 5) {
                    System.out.println("==5了，线程要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




