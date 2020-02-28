/**
 * This is the referee class which allows for the players to be assigned and starts the game off
 */
public class Referee{
    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    /**
     * An empty constructor as everything is assigned at a later time
     */
    public Referee(){
    }

    /**
     * Runs the game, assigning the opponents for each player and displays the board and starts the game for the xPlayer
     */
    public void runTheGame(){
        this.xPlayer.setOpponent(this.oPlayer);
        this.oPlayer.setOpponent(this.xPlayer);
        this.board.display();
        this.xPlayer.play();
    }

    /**
     * Assigns the board object to Referees board
     * @param board the game object with the functionality to play on
     */
    public void setBoard(Board board){
        this.board = board;
    }

    /**
     * Sets the O player
     * @param player This is the player case which allows for the player to make moves on the board
     */
    public void setoPlayer(Player player){
        this.oPlayer = player;
    }

    /**
     * Sets the X player
     * @param player This is the player case which allows for the player to make moves on the board
     */
    public void setxPlayer(Player player){
        this.xPlayer = player;
    }


}