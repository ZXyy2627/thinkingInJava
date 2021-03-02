package chap7_compositeAndInherit.exercise;

/**
 * 创建一个简单的类，在第二个类中，将一个引用定义为第一个类的对象。运用惰性初始化来实例化这个对象。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        School school = new School();
        school.f();
    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

class School{

    private Student student;

    public void f(){
        if(student == null){
            student = new Student("张三");
        }
        System.out.println(student.toString());
    }
}
