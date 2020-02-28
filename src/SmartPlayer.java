public class SmartPlayer extends BlockingPlayer {
    /**
     * The constructor for the player class assigns the name of the player and thier mark
     *
     * @param name the name given by the player
     * @param mark the mark of the player either X or O
     */
    public SmartPlayer(String name, char mark) {
        super(name, mark);
    }
}
