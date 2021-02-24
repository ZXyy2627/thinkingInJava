package chap5_initialize;

/**
 * 涉及到基本类型的重载方法：
 *      当传递的实际参数类型小于方法的形参类型时，基本数据类型会涉及到自动类型提升
 *
 *      提升的规则：
 *          除了char类型以外，都是一级一级的提升
 *          而char类型会直接提升至int类型
 *
 *      当传递的实际参数的类型大于方法的形参类型时，需要做强制类型转换,否则编译器报错
 *
 *
 *
 */
public class OverloadBasicData_3 {

    public static void main(String[] args) {
        OverloadBasicData_3 over = new OverloadBasicData_3();
        over.testByte(); //f1(byte)f2(byte)f3(short)f4(int)f5(long)f6(float)f7(double)  对于byte而言时一级一级的往上提升 从byte-short-int-long-float-double
        over.testChar();//f1(char)f2(int)f3(int)f4(int)f5(long)f6(float)f7(double)  对于char而言，看到f2,f3,f4方法调用的都是int参数类型的方法，所以时直接提升值int
    }

    public void f1(char x) {
        System.out.print("f1(char)");
    }

    public void f1(byte x) {
        System.out.print("f1(byte)");
    }

    public void f1(short x) {
        System.out.print("f1(short)");
    }

    public void f1(int x) {
        System.out.print("f1(int)");
    }

    public void f1(long x) {
        System.out.print("f1(long)");
    }

    public void f1(float x) {
        System.out.print("f1(float)");
    }
    public void f1(double x) {
        System.out.print("f1(double)");
    }


    public void f2(byte x){
        System.out.print("f2(byte)");
    }
    public void f2(short x){
        System.out.print("f2(short)");
    }
    public void f2(int x){
        System.out.print("f2(int)");
    }
    public void f2(long x){
        System.out.print("f2(long)");
    }
    public void f2(float x){
        System.out.print("f2(float)");
    }
    public void f2(double x){
        System.out.print("f2(double)");
    }

    public void f3(short x) {
        System.out.print("f3(short)");
    }
    public void f3(int x) {
        System.out.print("f3(int)");
    }
    public void f3(long x) {
        System.out.print("f3(long)");
    }
    public void f3(float x) {
        System.out.print("f3(float)");
    }
    public void f3(double x) {
        System.out.print("f3(double)");
    }

    public void f4(int x) {
        System.out.print("f4(int)");
    }
    public void f4(long x) {
        System.out.print("f4(long)");
    }
    public void f4(float x) {
        System.out.print("f4(float)");
    }
    public void f4(double x) {
        System.out.print("f4(double)");
    }

    public void f5(long x){
        System.out.print("f5(long)");
    }
    public void f5(float x){
        System.out.print("f5(float)");
    }
    public void f5(double x){
        System.out.print("f5(double)");
    }

    public void f6(float x) {
        System.out.print("f6(float)");
    }
    public void f6(double x) {
        System.out.print("f6(double)");
    }

    public void f7(double x){
        System.out.print("f7(double)");
    }

    public void testChar(){
        char x = 'x';
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    public void testByte() {
        byte x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }
}


