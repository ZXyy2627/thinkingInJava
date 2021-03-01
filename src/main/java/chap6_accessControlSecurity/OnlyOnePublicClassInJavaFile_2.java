package chap6_accessControlSecurity;
//package 指定包  它必须放在.java文件的第一行



/**
 * 每个.java文件中有且只能有一个public修饰的class
 */
public class OnlyOnePublicClassInJavaFile_2 {
    /*

        import java.util.ArrayList;

        在系统中配置CLASSPATH环境变量的时候，这个变量代表的路径就是class文件的根目录
        他会按照路径去找到根目录对应的文件夹，然后再来看import,例如是java.util包，
        它会把.转换成当前系统的路径符号，
        例如把 ："CLASSPATH\\java.util -----> CLASSPATH\\java\\util"
        然后再根据类名去找到相应的类ArrayList
     */
}

//public class A{ } 如果有两个public修饰的类，编译器会报错
