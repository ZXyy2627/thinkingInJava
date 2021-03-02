package chap7_compositeAndInherit;

/**
 * 如何初始化类中的引用?
 * 有4种方式：
 * ①在定义对象的地方。者意味者他们总是能在调用构造器之前得到初始化
 * ②在类的构造器中
 * ③在这个变量使用之前，这叫惰性初始化，就是只有要使用了，才初始化这个对象
 * ④使用实例初始化
 */
public class InitializeObject_3 {
    public static void main(String[] args) {
        Bath bath = new Bath();
    }
}

class Bath{
    private String str1 = "aaa";//在定义对象的地方初始化这个类中的引用
    private String str2;
    private String str3;
    public Bath() {
        str2 = "在类的构造器中初始化str2这个引用";
        System.out.println(str2);
    }

    public void f() {
        if(str3 == null ){
            str3 = "惰性初始化，在这个对象要使用之前才初始化它";
            System.out.println(str3);
        }
    }

    private int i;

    {i = 47;}//使用实例初始化
}
