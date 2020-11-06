package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class Queen extends Piece {

    /**
     *
     * @param b Board Object.
     * @param color Boolean to the set the color of the piece.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the board.
     *
     *
     */
    public Queen(Board b, boolean color, int xCoordinate, int yCoordinate) {

        super(b, color, xCoordinate, yCoordinate);

    }

    @Override
    public boolean isValidMove(int x, int y) {
        boolean isActuallyValid = false;
        int rowCheck;

        if (x == this.xCoordinate) {
            if (y > this.yCoordinate) {
                for (int i = (this.yCoordinate + 1); i < y; i++) {

                    if (board.pieces[x - 1][i - 1] != null) {
                        isActuallyValid = false;
                        return isActuallyValid;

                    } else {

                        isActuallyValid = true;
                    }

                }

            } else {
                for (int i = (this.yCoordinate - 1); i >= (y + 1); i--) {

                    if (board.pieces[x - 1][i - 1] != null) {

                        isActuallyValid = false;
                        return isActuallyValid;

                    } else {

                        isActuallyValid = true;
                    }

                }
            }

        } else if (y == this.yCoordinate) {
            if (x > this.xCoordinate) {
                for (int i = (this.xCoordinate + 1); i < x; i++) {

                    if (board.pieces[i - 1][y - 1] != null) {

                        isActuallyValid = false;
                        return isActuallyValid;

                    } else {

                        isActuallyValid = true;
                    }

                }

            } else if (x < this.xCoordinate) {
                for (int i = (this.xCoordinate - 1); i >= (x + 1); i--) {

                    if (board.pieces[i - 1][y - 1] != null) {

                        isActuallyValid = false;
                        return isActuallyValid;

                    } else {

                        isActuallyValid = true;
                    }

                }

            }

            //BISHOP 
            
        } else if (this.xCoordinate < x && this.yCoordinate > y) {
            rowCheck = (this.yCoordinate - 1);

            for (int i = (this.xCoordinate + 1); i <= x; i++) {

                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                if (board.pieces[i - 1][rowCheck - 1] != null) {

                    isActuallyValid = false;
                    return isActuallyValid;

                } else {
                    isActuallyValid = true;
                }
                rowCheck--;

            }

        } else if (this.xCoordinate > x && this.yCoordinate < y) {
            rowCheck = this.yCoordinate;

            for (int i = (this.xCoordinate - 1); i >= x; i--) {

                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                if (board.pieces[i - 1][rowCheck] != null) {
                    isActuallyValid = false;
                    return isActuallyValid;

                } else {
                    isActuallyValid = true;

                }
                rowCheck++;

            }

        } else if (this.xCoordinate < x && this.yCoordinate < y) {
            rowCheck = this.yCoordinate;

            for (int i = (this.xCoordinate + 1); i <= x; i++) {

                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                if (board.pieces[i - 1][rowCheck] != null) {
                    isActuallyValid = false;
                    return isActuallyValid;

                } else {
                    isActuallyValid = true;
                }
                rowCheck++;

            }

        } else if (this.xCoordinate > x && this.yCoordinate > y) {
            rowCheck = (this.yCoordinate - 1);

            for (int i = (this.xCoordinate - 1); i >= x; i--) {

                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                if (board.pieces[i - 1][rowCheck - 1] != null) {
                    isActuallyValid = false;
                    return isActuallyValid;

                } else {
                    isActuallyValid = true;
                }
                rowCheck--;

            }

        }
        return isActuallyValid;
    }

    /**
     *
     * @return Symbol for each Piece.
     */
    @Override
    public char getSymbol() {
        if (color) {
            return 'Q';

        } else {
            return 'q';
        }
    }

}
