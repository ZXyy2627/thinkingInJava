package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 上个实验证明了锁对象改变了，线程呈异步效果 接下来我们看如果对象没变，而是锁对象的值改变了是什么效果
 *
 * 从打印结果可以看到，如果仅仅是锁对象的值改变，而非锁对象改变，线程还是同步的，所以改变锁对象的值不会改变锁
 * 两个线程还是在使用同一个锁
 */
public class LockValueChange_37 {
    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();
        myLock.setAge(33);
        Service37 service37 = new Service37(myLock);
        Thread a37 = new Thread(new Runnable() {
            @Override
            public void run() {
                service37.testMethod1();
            }
        },"A");
        a37.start();
        Thread.sleep(200);
        Thread b37 = new Thread(new Runnable() {
            @Override
            public void run() {
                service37.testMethod1();
            }
        },"B");
        b37.start();
    }
}

class MyLock{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Service37 {
    private MyLock myLock;

    public Service37(MyLock myLock){
        this.myLock = myLock;
    }

    public void testMethod1(){
        try {
            synchronized (myLock){
                System.out.println("threadName = "+Thread.currentThread().getName()+
                    " 在 "+System.currentTimeMillis()+"进入了方法");
                myLock.setAge(22);
                Thread.sleep(2000);
                System.out.println("threadName = "+Thread.currentThread().getName()+
                        " 在 "+System.currentTimeMillis()+"离开了方法");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
