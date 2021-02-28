package chap5_initialize;

import java.util.Arrays;

/**
 * 1.数组可以直接赋值给另一个数组
 *
 * 2.数组的属性length代表数组的长度，也就是数组中元素的个数
 */
public class ArrayCopy_15 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = a;
        //但是这里只是把a数组的引用复制了一份给b数组，事实上他们指向的还是同一片存储空间
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        //如果改变a中的一个元素，看看b
        a[1] = 5;
        System.out.println("改变a的元素后==="+Arrays.toString(a));
        System.out.println("改变a的元素后==="+Arrays.toString(b));
    /*
        改变a的元素后===[1, 5, 3]
        改变a的元素后===[1, 5, 3]
        从打印结果可以看到，改变了a的元素后，b的元素也改变了，这充分的说明了只是把引用拷贝给了b。
     */

        /*
            注意数组的长度是属性length，而不是length()方法
         */
        int[] c = new int[10];
        System.out.println("C的长度是:"+c.length);//C的长度是:10
        int[] d = {1, 2, 3, 4};
        System.out.println("D的长度是："+d.length);//D的长度是：4
    }
}
