package chess;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public abstract class Piece {

    protected boolean color;
    protected boolean hasBeenMoved;
    protected int xCoordinate;
    protected int yCoordinate;
    protected Board board;

    /**
     *
     * @param b A Board Object.
     * @param color Boolean for color.
     * @param xCoordinate Column Position of the Piece on the board.
     * @param yCoordinate Row Position of the Piece on the Board.
     *
     */
    public Piece(Board b, boolean color, int xCoordinate, int yCoordinate) {
        board = b;
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        hasBeenMoved = false;

    }

    /**
     *
     * @param x Column position the Piece is to be moved to on the Board.
     * @param y Row position the Piece is to be moved to on the Board.
     * @throws chess.InvalidMoveException
     */
    /*
     * Checks if the Positions actually are on the Board.
     * Checks the position for any existing pieces and removes the existing 
     * piece and sets this piece to the new position.
     * Or simply just sets the piece to the new Position.
     * 
     */
    public void move(int x, int y) throws InvalidMoveException {

        if (isValidMove(x, y)) {

            if (board.pieces[x - 1][x - 1] != null) { //(Pstn moving to not null)
                board.pieces[x - 1][y - 1] = null;
                board.pieces[x - 1][y - 1] = this;
                board.pieces[this.xCoordinate - 1][this.yCoordinate - 1] = null;

                this.xCoordinate = x;
                this.yCoordinate = y;
                hasBeenMoved = true;
                board.isWhiteTurn = (!(board.isWhiteTurn));

            } else {
                board.pieces[this.xCoordinate - 1][this.yCoordinate - 1] = null;
                board.pieces[x - 1][y - 1] = this;
                this.xCoordinate = x;
                this.yCoordinate = y;
                hasBeenMoved = true;
                board.isWhiteTurn = (!(board.isWhiteTurn));

            }
        } else {

            throw new InvalidMoveException("A "
                    + this.getClass().getSimpleName()
                    + " cannot move there.");

        }
    }

    //Method implmentated in each SubClass
    public abstract boolean isValidMove(int x, int y);

    //Method implimentated each SubClass
    public abstract char getSymbol();

}
