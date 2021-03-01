package chap5_initialize;

import java.util.Arrays;

/**
 * 创建枚举类型
 */
public class EnumAndMethod_18 {
    public static void main(String[] args) {
        /*
         *  在创建枚举类型的时候，编译器会自动添加一些有用的特性，如枚举类型的顺序，toString打印方法
         * 以及静态的values方法
         */
        Spicinse howHot = Spicinse.HOT;
        System.out.println(howHot.toString());
        System.out.println("HOT是枚举类型第几个创建的"+howHot.ordinal());//下标是从0开始的
        System.out.println("该枚举类型的值"+ Arrays.toString(Spicinse.values()));//直接打印是对象地址值
    }
}

/**
 * 创建枚举类型
 * 枚举类型的实例就是常量，一般都用大写字母表示
 */
enum Spicinse{
    NOT,MILD,MEDIUM,HOT,FLAMING
}
