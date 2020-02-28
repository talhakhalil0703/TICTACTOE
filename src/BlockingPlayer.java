public class BlockingPlayer extends RandomPlayer {
    /**
     * The constructor for the player class assigns the name of the player and thier mark
     *
     * @param name the name given by the player
     * @param mark the mark of the player either X or O
     */
    public BlockingPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove() {
        for (int i =0; i <= 2; i++){
            for (int j =0; j <= 2; j++){
                if (testForBlocking(i,j)){
                    this.getBoard().addMark(i, j, this.getMark());
                    return;
                }
            }
        }

        super.makeMove();
    }

    private boolean testForBlocking(int i, int j) {
        if (this.getBoard().getMark(i, j) == Constants.SPACE_CHAR) {
            int mark = this.getBoard().getMarkCount();
            this.getBoard().addMark(i, j, this.getOpponent().getMark());
            int winner = this.getBoard().checkWinner(this.getOpponent().getMark());
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
