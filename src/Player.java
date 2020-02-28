import java.util.Scanner;

/**
 * This is the player class which allows for the player to make moves on the board
 */
public abstract class Player {
    private String name;
    private Board board;
    private Player opponent;
    private char mark;

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public Player getOpponent() {
        return opponent;
    }

    public char getMark() {
        return mark;
    }

    /**
     * The constructor for the player class assigns the name of the player and thier mark
     *
     * @param name the name given by the player
     * @param mark the mark of the player either X or O
     */
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Main loop of the game which decides which players turn it is and checks if the game has ended
     */
    public void play() {
        if (!this.board.xWins() && !this.board.oWins() && !this.board.isFull()) {
            this.makeMove();
            this.board.display();
        }

        if (this.board.xWins())
            System.out.println("pack1.Player X has won!");
        else if (this.board.oWins())
            System.out.println("pack1.Player O has won!");
        else if (this.board.isFull())
            System.out.println("It was a Tie!");
        else
            this.opponent.play();
    }

    /**
     * Takes the input of the user for the move they would like to perfrom
     */
    public abstract void makeMove();

    /**
     * Sets the opponent player for the player object
     *
     * @param player the opposing player
     */
    public void setOpponent(Player player) {
        this.opponent = player;
    }

    /**
     * The game board on which the game is played on
     *
     * @param board the game object with the functionality to play on
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}