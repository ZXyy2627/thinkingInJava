package chap5_initialize;

/**
 * 对成员变量指定初始化
 *
 * 1.可以直接给成员变量赋值
 * 2.也可以使用构造器初始化成员变量
 * 3.也可以使用方法对成员变量初始化
 */
public class SpecifyInitialize_9 {
    public static void main(String[] args) {
        Init init = new Init();
        System.out.println(init.str);
        System.out.println(init.str2);
        System.out.println(init.str3);
    }
}

class Init{
    public String  str3 = "我是直接赋值的成员变量";//对成员变量进行直接赋值初始化

    public String str;

    public Init() {
        this.str = "我是构造器初始化的字符串";
    }

    public String str2=f1();
    public String f1(){
        return "我是普通方法初始化成员变量";
    }
}
