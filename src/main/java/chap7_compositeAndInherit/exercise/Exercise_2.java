package chap7_compositeAndInherit.exercise;

/**
 * 练习2：从Detergent中继承产生一个新的类，并且覆盖scrub方法，并添加一个新的sterilize()方法
 */
public class Exercise_2 {
    public static void main(String[] args) {
        ExerciseDetergent exerciseDetergent = new ExerciseDetergent();
        exerciseDetergent.scrub();
        exerciseDetergent.sterilize();
        System.out.println(exerciseDetergent);
    }
}

class Detergent {

    private String s = "Detergent";

    public void append(String a) {
        s += a;
    }

    public void scrub(){
        append(" detergent scrub()");
    }

    public String toString() {
        return s;
    }
}

class ExerciseDetergent extends Detergent {
    public void scrub(){
        append(" exerciseDetergent scrub");
    }

    public void sterilize() {
        append(" sterilize() ");
    }
}

