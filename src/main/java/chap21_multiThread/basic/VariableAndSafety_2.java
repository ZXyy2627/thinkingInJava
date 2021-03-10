package chap21_multiThread.basic;

import javax.lang.model.element.VariableElement;

/**
 * 实例变量与线程安全
 *
 * 证明：方法内部的局部变量是线程安全的
 *
 * 从打印结果可以看到，两个线程在独立的计算num变量的值 互不影响 没有出现线程安全的问题
 */
public class VariableAndSafety_2 {
    public static void main(String[] args) {
        VariableInMethod t1 = new VariableInMethod();
        t1.start();
        VariableInMethod t2 = new VariableInMethod();
        t2.start();
    }
}

class VariableInMethod extends Thread{
    @Override
    public void run(){
        int num = 100;
        while (num > 0) {
            num--;
            System.out.println(Thread.currentThread().getName() +"线程在计算num  ,num = " +num);
        }
    }
}
