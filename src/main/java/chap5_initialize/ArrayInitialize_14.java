package chap5_initialize;

import java.util.Arrays;

/**
 * 什么是数组？
 * 数据就是一组同一类型的对象或基本类型数据的序列。
 * 如何定义数组？
 * 定义数组的三种方式
 *
 * 1. int[] a = {1,2,3};
 * 2. int a[] = new int[5];
 * 3. int[] a = new int[]{4,5,6};
 */
public class ArrayInitialize_14 {
    public static void main(String[] args) {
        /*
            如何定义数组
         */
        //方式1：
        int[] a = {2,3,4};  //直接使用大括号定义数组中的元素
        //方式2：
        int a1[] = new int[5];//定义一个长度为5的数组
        //方式三
        String[] strs = new String[]{"a","b","c"};//定义一个数组，里面包含三个字符串元素
        System.out.println(a.toString());//[I@1b6d3586 这是a数组的引用
        System.out.println(Arrays.toString(strs));//[a, b, c]
        /*
            从打印结果看，如果想知道数组中的元素，需要使用Arrays.toString()方法,而不是使用默认的toString方法
         */
    }
}
