package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class Pawn extends Piece {

    /**
     *
     * @param b Board Object.
     * @param color Boolean to the set the color of the piece.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the board.
     *
     */
    public Pawn(Board b, boolean color, int xCoordinate, int yCoordinate) {
        super(b, color, xCoordinate, yCoordinate);

    }

    /**
     *
     * @param x Column on the board to move to.
     * @param y Row on the board to move to.
     * @return true if a Piece is allowed to move there according to chess
     * Rules.
     */
    @Override
    public boolean isValidMove(int x, int y) {

        //Checks if the column doesnt change for each Piece.
        if (x == (this.xCoordinate)) {

            //When the Piece is White.
            if (color) {

                //Checks if a white piece has not been moved atleast once.
                if (!(this.hasBeenMoved)) {

                    if (board.pieces[x - 1][y - 1] == null) {
                        //It can either move one box ahead.
                        if (y == (this.yCoordinate - 1)) {
                            return true;
                            //Or two boxes if there is no piece in between.
                        } else if (y == (this.yCoordinate - 2)
                                && this.board.pieces[x - 1][y] == null) {

                            return true;

                        }

                    }

                    //If the piece has already been moved  
                } else {
                    System.out.println("inside elses");
                    //It can only move one box ahead.
                    if (board.pieces[x - 1][y - 1] == null) {
                        System.out.println("the first if statement");
                        return (y == (this.yCoordinate - 1));

                    }

                }
                // Black Piece validMove.
                //Checks if a black piece has not been moved initially or not.
            } else if (!(this.hasBeenMoved)) {

                if (board.pieces[x - 1][y - 1] == null) {
                    //It can either move one box ahead.
                    if (y == (this.yCoordinate + 1)) {
                        return true;

                        //Or two boxes if there is no piece in between.
                    } else if ((y == this.yCoordinate + 2)
                            && this.board.pieces[x - 1][y - 2] == null) {

                        return true;
                    }

                }

                //If the piece has already been moved 
            } else {

                if (board.pieces[x - 1][y - 1] == null) {
                    //It can only move one box ahead.
                    return (y == (this.yCoordinate + 1));

                }

            }
        }

        //Capture code
        //Integer variables to store values containing positions to check 
        //when a pawn is capturing other Pieces.
        int xOffset;
        int yOffset;

        //This code also depends on the color.
        if (color) {

            //If the position is between 2 && 7 this code is executed.
            if (this.xCoordinate > 1 && this.xCoordinate < 8) {

                //Depending on the side the pawn wants to capture Diagonally
                //the xOffset values and yOffset values are set.
                if (this.xCoordinate > x) {
                    xOffset = (this.xCoordinate - 2);

                } else {
                    xOffset = this.xCoordinate;
                }
                //The yValue to work with on the array is the same for both 
                //side movements.
                yOffset = (this.yCoordinate - 2);

                // White pawn moving to Capture.
                //If the Piece the Pawn is going to capture is a Queen 
                // then that move is invalid.
                if (board.pieces[xOffset][yOffset] instanceof Queen) {

                    return false;
                } else if (board.pieces[xOffset][yOffset] != null) {

                    return (x == (xOffset + 1)
                            && y == (yOffset + 1));

                }

                //White Pawn Piece Capture code when it is on column one.
                if (this.xCoordinate == 1) {

                    xOffset = this.xCoordinate;
                    yOffset = (this.yCoordinate - 2);

                    if (board.pieces[xOffset][yOffset] instanceof Queen) {

                        return false;
                    } else if (board.pieces[xOffset][yOffset] != null) {
                        return (x == (this.xCoordinate + 1)
                                && y == (this.yCoordinate - 1));
                    }

                }

                //White Pawn Piece Capture code when it is on column eight.
                if (this.xCoordinate == 8) {

                    xOffset = (this.xCoordinate - 2);
                    yOffset = (this.yCoordinate - 2);

                    if (board.pieces[xOffset][xOffset] instanceof Queen) {

                        return false;
                    } else if (board.pieces[xOffset][yOffset] != null) {
                        return (x == (this.xCoordinate - 1)
                                && y == (this.yCoordinate - 1));
                    }

                }

            }

        } else {

            //When a Balck Pawn Piece is between 2 and 7 on the Board
            if (this.xCoordinate > 1 && this.yCoordinate < 8) {

                if (this.xCoordinate > x) {
                    xOffset = (this.xCoordinate - 2);
                } else {
                    xOffset = this.xCoordinate;
                }

                yOffset = this.yCoordinate;

                if (board.pieces[xOffset][yOffset] instanceof Queen) {
                    return false;

                } else if (board.pieces[xOffset][yOffset] != null) {
                    return (x == (xOffset + 1)
                            && y == (yOffset + 1));

                }

                //Black Pawn Piece Capture code when it is on column one.
                if (this.xCoordinate == 1) {

                    xOffset = this.xCoordinate;
                    yOffset = this.yCoordinate;

                    if (board.pieces[xOffset][yOffset] instanceof Queen) {
                        return false;

                    } else if (board.pieces[xOffset][yOffset] != null) {
                        return (x == (this.xCoordinate + 1)
                                && y == (this.yCoordinate + 1));

                    }

                    //Black Pawn Piece Capture code when it is on column Eight.
                    if (this.xCoordinate == 8) {

                        xOffset = (this.xCoordinate - 2);
                        yOffset = (this.yCoordinate);

                        if (board.pieces[xOffset][yOffset] instanceof Queen) {

                            return false;

                        } else if (board.pieces[xOffset][yOffset] != null) {
                            return (x == (this.xCoordinate - 1)
                                    && y == (this.yCoordinate + 1));

                        }

                    }

                }

            }

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
            return 'P';

        } else {
            return 'p';
        }

    }

}
