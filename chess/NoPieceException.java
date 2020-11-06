package chess;

/**
 *
 * @author Parth Patel.
 *
 * Thrown when there is no piece at the coordinates to move.
 *
 */
public class NoPieceException extends ChessException {

    public NoPieceException() {
        super("No piece found to make a move.");
    }

    public NoPieceException(String message) {
        super(message);
    }
}
