package chess;

/**
 *
 * @author Parth Patel.
 *
 * Thrown when a piece is not moved according to Chess Rules.
 */
public class InvalidMoveException extends ChessException {

    public InvalidMoveException() {
        super(" An invalid move");
    }

    public InvalidMoveException(String message) {
        super(message);
    }
}
