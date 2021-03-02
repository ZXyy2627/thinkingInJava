package chap7_compositeAndInherit;

/**
 * 继承语法  使用extends关键字实现
 *
 * 如果想要在导出类中调用基类的方法，可以使用super关键字
 */
public class InheritanceSyntax_4 {
    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
        System.out.println("test extends class");//Cleanser dilute()  apply()  scrub()
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);//Cleanser dilute()  apply()  Detergent.scrub()  foam()
        /*
            从打印结果可以看到，Detergent继承了Cleanser类，就继承了Cleanser类的成员方法
            dilute()和apply()方法
            然后重写了scrub()方法
            并且新增了foam()方法
         */
    }
}

class Cleanser{
    private String s = "Cleanser";

    public void append(String a) {
        s+=a;
    }

    public void dilute() {
        append(" dilute() ");
    }

    public void apply() {
        append(" apply() ");
    }

    public void scrub() {
        append(" scrub() ");
    }

    public String toString() {
        return s;
    }
}

class Detergent extends Cleanser {
    public void scrub() {
        //如果想要在导出类中，调用基类的方法，可以使用super关键字
        super.scrub();
        append(" Detergent.scrub() ");
    }

    public void foam() {
        append( " foam() ");
    }
}




