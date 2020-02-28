import java.util.Scanner;

public class HumanPlayer extends Player {

    /**
     * The constructor for the player class assigns the name of the player and thier mark
     *
     * @param name the name given by the player
     * @param mark the mark of the player either X or O
     */
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove() {
        Scanner scan =  new Scanner(System.in);
        System.out.println(this.getName() + ", what row should your next " + this.getMark() + " be placed in?");
        int num = scan.nextInt();
        System.out.println(this.getName() + ", what column should your next " + this.getMark() + " be placed in?");
        int num2 = scan.nextInt();
        this.getBoard().addMark(num, num2, this.getMark());
    }

}
