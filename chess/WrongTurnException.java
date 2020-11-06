package chess;

/**
 *
 * @author Parth Patel.
 *
 * Thrown when the Wrong color is moved at the Wrong time.
 */
public class WrongTurnException extends ChessException {

    public WrongTurnException() {
        super(" It's not your turn.");
    }

    public WrongTurnException(String message) {
        super(message);
    }

}
