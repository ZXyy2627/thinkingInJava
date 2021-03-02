package chap7_compositeAndInherit.exercise;

/**
 * 证明基类的构造器
 * 1）总是会被调用
 * 2）在导出类构造器之前被调用
 */
public class Exercise_4 {
    public static void main(String[] args) {
        Drawing1 drawing1 = new Drawing1();
    }
}

class Art1{
    Art1() {
        System.out.println("这是基类的构造器");
    }
}

class Drawing1 extends Art1 {
    Drawing1(){
        System.out.println("这是子类构造器，被调用了");
    }
}
