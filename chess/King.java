package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class King extends Piece {

    /**
     *
     * @param b Board Object.
     * @param color Boolean to the set the color of the piece.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the board.
     *
     */
    public King(Board b, boolean color, int xCoordinate, int yCoordinate) {

        super(b, color, xCoordinate, yCoordinate);

    }

    @Override
    public boolean isValidMove(int x, int y) {
        boolean validMove = false;

        if (x == (this.xCoordinate - 1)
                || x == (this.xCoordinate + 1)
                || y == (this.yCoordinate + 1)
                || y == (this.yCoordinate - 1)) {
            validMove = true;

        }

        return validMove;

    }

    /**
     *
     * @return Symbol for each Piece.
     */
    @Override
    public char getSymbol() {
        if (color) {
            return 'K';

        } else {
            return 'k';
        }
    }

}
