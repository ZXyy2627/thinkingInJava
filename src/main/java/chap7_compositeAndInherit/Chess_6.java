package chap7_compositeAndInherit;

/**
 * 如果基类没有默认的无参构造器，导出类必须显示的调用基类的带参构造器，并且是在基类构造器中的第一句话
 */
public class Chess_6 extends BoardGame{
    Chess_6() {
        super(11);
        System.out.println("chess的构造器被调用了");
    }

    public static void main(String[] args) {
        Chess_6 chess_6 = new Chess_6();
    }
}

class Game {
    Game(int i) {
        System.out.println("Game的构造器被调用了");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);//必须写在导出类构造器的第一行
        System.out.println("BoardGame的构造器被调用了");
        //super(i);//如果不是在第一句调用基类的带参构造器，编译器会报错
    }
}
