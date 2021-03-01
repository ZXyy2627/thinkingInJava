package chap6_accessControlSecurity;

/**
 * Java访问权限修饰词  有public ,protected, (包访问权限),private
 *
 * 1.包访问权限
 *      什么是包访问权限？  就是前面什么都不写，没有修饰词
 *      包访问权限的作用：就是当前包的所有类都可以访问该成员变量或者方法。其他包就不行
 *
 *
 * 如何取得对某个成员的访问权：
 * ①使用public修饰该成员
 * ②不加任何访问修饰词，并且把该成员所属的类放在与当前类同一包下
 * ③提供getter/setter方法
 * ④在继承的结构中使用public或者protected关键字修饰，还是无法访问到private修饰的成员
 *
 * 2.public 访问权限 所有人都可以访问，不管是否在同一个包中
 *
 * 3.protected 继承访问权限
 *      就是说你想要一个类的某些成员不被其他类访问到，但是它所有的导出类都可以访问到，就使用protected关键字修饰
 *      当然，protected其实就提供包访问权限
 *
 * 4.private 你无法访问
 *      使用private修饰的成员，只有自己可以访问到，其他类不论是否在同一个包中，都无法访问到
 */
public class AccessControlWord_3 {
}

class Student{

    int age; //该成员变量前什么都没有，默认就是包访问权限

    void f(){
        System.out.println("默认的包访问权限，只要是这个包中都可以访问");
    }
}
