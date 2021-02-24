package chap5_initialize;

/**
 * 构造器初始化
 *
 * 如果是类的成员变量，事实上在调用构造器之前就已经初始化了
 */
public class ConstructorInitialize_10 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println(counter.i);
        /*
        i的值是:0
        10
        从打印结果可以看到，当调用构造器之前，i的值就已经是0了，说明在调用构造器之前，类的成员变量就已经被初始化了
         */
    }
}

class Counter{
    int i;

    public Counter() {
        System.out.println("i的值是:"+i);
        this.i = 10;
    }
}
