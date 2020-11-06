package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class Bishop extends Piece {

    /**
     *
     * @param b Board Object.
     * @param color Boolean to the set the color of the piece.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the board.
     *
     */
    public Bishop(Board b, boolean color, int xCoordinate, int yCoordinate) {

        super(b, color, xCoordinate, yCoordinate);

    }

    @Override
    public boolean isValidMove(int x, int y) {

        boolean isActuallyValid = false;
        //int rowCheck- is used as a refenrence to check if the boxes in between
        //are empty.
        int rowCheck;

        //If this Bishop is going to move towards the right diagonally.
        if (this.xCoordinate < x && this.yCoordinate > y) {
            //Set rowCheck
            rowCheck = (this.yCoordinate - 1);
            //A loop is used to go through all the positions in between the two 
            //coordinates.
            for (int i = (this.xCoordinate + 1); i <= x; i++) {

                //If just moving one box diagonally the piece is allowed to.
                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                //If even one position in between is not empty the move 
                //is invalid and the false value is immidiately returned.
                if (board.pieces[i - 1][rowCheck - 1] != null) {

                    isActuallyValid = false;
                    return isActuallyValid;

                    ////If all the positions in between are empty that
                    //means it is a valid move.
                } else {
                    isActuallyValid = true;
                }
                rowCheck--;

            }

            // If the piece wants to move Diagonally left and downwards.
        } else if (this.xCoordinate > x && this.yCoordinate < y) {
            //Set the rowCheck
            rowCheck = this.yCoordinate;

            //Looping through all the positions in between.
            for (int i = (this.xCoordinate - 1); i >= x; i--) {

                //If the piece just wants to move one position Diagoanally
                //then it is a valid  move.
                if (x == i) {
                    isActuallyValid = true;
                    return isActuallyValid;
                }

                //If even one position in between is not null 
                //that move becomes invalid.
                if (board.pieces[i - 1][rowCheck] != null) {
                    isActuallyValid = false;
                    return isActuallyValid;

                    //Else if is a valid move.
                } else {
                    isActuallyValid = true;

                }
                rowCheck++;

            }
            
            //If

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
            return 'B';

        } else {
            return 'b';
        }
    }

}
