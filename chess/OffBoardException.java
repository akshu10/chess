package chess;

/**
 *
 * @author Parth Patel.
 *
 * Thrown when the coordinates are not on the board.
 *
 */
public class OffBoardException extends ChessException {

    public OffBoardException() {
        super("At least one coordinate was invalid");
    }

    public OffBoardException(String message) {
        super(message);
    }

}
