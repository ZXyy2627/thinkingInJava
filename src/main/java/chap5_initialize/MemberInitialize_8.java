package chap5_initialize;

/**
 * 在方法内部没有初始化一个变量，则编译器会报错
 *
 * 对于类的成员来说，也需要初始化，但是可以不用显示的初始化，因为编译器会帮我们初始化这些成员变量
 *
 * 对于基本类型成员变量，编译器会给相对应类型的一个默认值
 * 对于引用类型成员变量，编译器会给一个null值
 */
public class MemberInitialize_8 {
    public static void main(String[] args) {
        /*
        0
        0

        0
        0
        0.0
        0.0
        false
        null
        */
        /*
            从打印结果可以看到：  初始化都给了每个基本类型一个默认值 char类型的值是0，但是显示的是空白
            boolean 类型的默认值是false
            引用类型的默认值是null
         */

        Member member = new Member();
        System.out.println(member.a);
        System.out.println(member.b);
        System.out.println(member.c);
        System.out.println(member.d);
        System.out.println(member.e);
        System.out.println(member.f);
        System.out.println(member.g);
        System.out.println(member.h);
        System.out.println(member.str);
    }
}

class Member{
    public byte a;
    public short b;
    public char c;
    public int d;
    public long e;
    public float f;
    public double g;
    public boolean h;
    public String str;
}
