package chap7_compositeAndInherit;

/**
 * 组合语法
 *
 * 就是将一个类的对象，置于另一个新的类中，由于这个新的类是由现有类的对象组合而来，所以叫组合。
 */
public class Composite_2 {

}

class WaterSource{
    private String s;
    WaterSource(){
        System.out.println("WaterSource的构造器执行了");
        s = "WaterSource Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

class SprinklerSystem{
    private String value1,value2,value3,value4;
    private WaterSource waterSource = new WaterSource();  //由现有类的对象组合而来的新类
    private int i;
    private float f;

    @Override
    public String toString() {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + "\n" +
                "i = " + i + " " + "f = " + f +" "+
                "source = " + waterSource ;
    }
}
