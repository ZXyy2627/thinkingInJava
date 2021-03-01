package chap6_accessControlSecurity.exercise;

import chap6_accessControlSecurity.PackageMean_1;

/**
 * 练习1：再某个包中创建一个类，在这个包所处的外部创建该类的实例
 */
public class Exercise_1 {
    public static void main(String[] args) {
        PackageMean_1 packageMean1 = new PackageMean_1();
        System.out.println(packageMean1);
    }
}
