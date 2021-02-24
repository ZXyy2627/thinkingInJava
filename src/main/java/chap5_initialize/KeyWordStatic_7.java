package chap5_initialize;

/**
 * static的作用表示静态
 *
 * 1.在static方法中不能使用this关键字
 * 2.在static方法中不能使用非静态变量和调用非静态方法
 * 3.static方法中可以访问静态域
 * 4.在非static方法中可以访问static方法
 *
 * 总结：静态的方法只能访问静态的域和方法
 * 非静态方法中可以访问静态的域和方法
 */
public class KeyWordStatic_7 {
    private int a = 0;
    private static int b = 10;

    public void unStaticMethod(){
        System.out.println("这是非静态域a:"+a);
        System.out.println("这是静态域b:"+b);//证明非静态方法可以访问静态域
        System.out.println("这是非静态方法");
        staticMethod();//证明非静态方法中可以调用静态方法
    }

    public static void staticMethod() {
        //System.out.println("这是非静态域a:"+a);//编译器报错，证明静态方法中不能访问非静态域
        System.out.println("这是非静态域b:"+b);//编译器不报错，证明静态方法中可以访问静态域
        System.out.println("这是静态方法");
        //unStaticMethod();//编译器报错  证明静态方法中不能调用非静态方法
    }
}
