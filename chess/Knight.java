package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class Knight extends Piece {

    /**
     *
     * @param b Board Object.
     * @param color Boolean to the set the color of the piece.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the board.
     *
     *
     */
    public Knight(Board b, boolean color, int xCoordinate, int yCoordinate) {

        super(b, color, xCoordinate, yCoordinate);

    }

    @Override
    public boolean isValidMove(int x, int y) {

        //Can move 2 rows and 1 column in any direction.
        if ((x == (this.xCoordinate + 1) || x == (this.xCoordinate - 1))
                && (y == (this.yCoordinate + 2) || y == (this.yCoordinate - 2))) {
            return true;

            //Can move 1 column and 2 rows in any Direction.
        } else if ((x == (this.xCoordinate + 2) || x == (this.xCoordinate - 2))
                && (y == (this.yCoordinate + 1) || y == (this.yCoordinate - 1))) {
            return true;

        }

        return false;
    }

    /**
     *
     * @return Symbol for each Piece.
     */
    @Override
    public char getSymbol() {
        if (color) {
            return 'N';

        } else {
            return 'n';
        }

    }

}
