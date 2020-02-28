public class RandomPlayer extends Player {

    /**
     * The constructor for the player class assigns the name of the player and thier mark
     *
     * @param name the name given by the player
     * @param mark the mark of the player either X or O
     */
    public RandomPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove() {
        RandomGenerator generateRandom = new RandomGenerator();
        boolean placed = false;

        while(!placed) {
            int num = generateRandom.discrete(0, 2);
            int num2 = generateRandom.discrete(0, 2);

            if (this.getBoard().getMark(num, num2) == Constants.SPACE_CHAR) {
                this.getBoard().addMark(num, num2, this.getMark());
                placed = true;
            }
        }
    }
}
