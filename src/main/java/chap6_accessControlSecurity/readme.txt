总结：
第六章  访问权限控制
访问权限控制就是隐藏具体实现，也可以说访问权限控制就是为了重构类库代码而产生的
Java中有4种访问权限：1.public 2.包访问权限 3.protected 4.private

1.什么是包？
    包就是一组类库存放的空间  就好比系统中的文件夹一样

2.每个.java文件中只有一个public修饰的类，有且仅有一个  但是可以有多个包访问权限的类

3.包名需要独一无二，一般情况下，我们使用com.域名来实现

4.冲突：如果两个不同的包中，有两个相同的名字的类，那么在使用的时候，需要写该类的完整包名
    例如： java.util.ArrayList list = new java.util.ArrayList();

5.导入某个包可以用import关键字

6.package 关键字一般在每个.java文件的第一行

7.包访问权限，就是默认的，什么都不写，没有任何关键字  意味着只要在与这个类处于同一包中，都可以访问该成员

8.public 接口访问权限  不管是否与该类在同一个包，都可以访问该类的成员

9.protected 继承访问权限
    为了让处于继承结构中的类，如果某些成员不想让其他类访问，但是又想让该类的导出类访问，那就可以使用
    protected关键字，它修饰的成员只有它的子类可以访问

10.private 你无法访问  只有自己可以访问private修饰的成员

