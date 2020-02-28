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

    @Override
    public void makeMove() {

        for (int i =0; i <= 2; i++){
            for (int j =0; j <= 2; j++){
                if (testForWinning(i,j)){
                    this.getBoard().addMark(i, j, this.getMark());
                    return;
                }
            }
        }
        super.makeMove();
    }

    private boolean testForWinning(int i, int j) {
        if (this.getBoard().getMark(i, j) == Constants.SPACE_CHAR) {
            int mark = this.getBoard().getMarkCount();
            this.getBoard().addMark(i, j, this.getMark());
            int winner = this.getBoard().checkWinner(this.getMark());
            this.getBoard().addMark(i, j, Constants.SPACE_CHAR);
            this.getBoard().setMarkCount(mark);

            if (winner == 1)
                return true;
            else
                return false;
        }
        return false;
    }
}
