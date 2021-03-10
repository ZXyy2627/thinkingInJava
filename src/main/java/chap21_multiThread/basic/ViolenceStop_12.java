package chap21_multiThread.basic;

/**
 * 使用废弃的stop方法停止线程
 * 这个方法已经过时了 ，不推荐使用它停止线程
 */
public class ViolenceStop_12 {
    public static void main(String[] args) {
        try {
            ThreadA12 t12 = new ThreadA12();
            t12.start();
            Thread.sleep(8000);
            t12.stop();//这是一个废弃的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA12 extends Thread {
    private int i = 0;
    @Override
    public void run() {
        while(true){
            i++;
            System.out.println("ThreadName = "+Thread.currentThread().getName()
                +"----i----" +i);
        }
    }
}
