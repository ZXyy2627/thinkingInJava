package chap21_multiThread.basic;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * getId()方法获取线程的唯一标识
 *
 * 从打印结果可以看到，main线程和t7这个线程的唯一标识不一样
 */
public class GetIdMethod_7 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"线程的id是"+Thread.currentThread().getId());
        Thread7 t7 = new Thread7();
        t7.start();
    }
}

class Thread7 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程的id是" +Thread.currentThread().getId());
    }
}
