package chap5_initialize;

/**
 * this 关键字表示当前对象的引用
 * 在方法内部使用代表 当前对象的引用
 */
public class KeyWordThis_5 {
    public static void main(String[] args) {
        Leaf leaf = new Leaf();
        System.out.println(leaf);
        leaf.increment().increment().increment().increment();
        System.out.println("i的值是:"+leaf.i);//4
        /*
            从打印结果来看，i的值自增了4次，正式因为increment方法返回的是当前对象的引用，所以每次返回的都是同一个对象
            才能使打印结果是4

            增加打印语句再次来看打印结果：
            chap5_initialize.Leaf@1b6d3586  这是第一次通过构造器初始化的对象
            chap5_initialize.Leaf@1b6d3586  以下是4次打印语句中的this代表的对象的引用  可以看到都是代表同一个对象的引用
            chap5_initialize.Leaf@1b6d3586
            chap5_initialize.Leaf@1b6d3586
            chap5_initialize.Leaf@1b6d3586
            i的值是:4
         */
    }
}

class Leaf{
    int i = 0;
    public Leaf increment(){
        i++;
        //返回当前对象的引用
        System.out.println(this);
        return this;
    }
}
