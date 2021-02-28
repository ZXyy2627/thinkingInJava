package chap5_initialize;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组是在运行时创建的
 *
 */
public class ArrayNew_16 {
    public static void main(String[] args) {
        int[] a;
        //System.out.println(a.length);//这里编译器在报错，说明数组是在运行时创建的，而不是编译期。
        Random random = new Random();
        a = new int[random.nextInt(20)];
        System.out.println(Arrays.toString(a));
    }
}
