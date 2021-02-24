package chap5_initialize;

/**
 * 从上一个例子可以看到this代表当前对象的引用  并且只能在方法中使用
 *
 * this 也可以用于在构造器中调用另一个构造器
 * 并且只能使用一次
 * 并且使用this在构造器中调用另一个构造器，this调用只能写在该构造器的第一行
 */
public class KeyWordThisConstructor_6 {
}

class Student{
    private String name;
    private int age;
    private String date;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String date) {
        this.date = date;
    }

    public Student(String name,int age,String date){
        //System.out.println("aaa");//如果this调用另一个构造器不是在构造器内的第一行，编译器会报错
        //在构造器内部调用另一个构造器
        this(name,age);
        //this(date);//此处编译器报错，因为在构造器中使用this调用另一个构造器只能使用一次
    }
}

