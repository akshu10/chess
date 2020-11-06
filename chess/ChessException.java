package chess;

/**
 *
 * @author Parth Patel.
 *
 * All other Exceptions inherit from this general class.
 *
 */
public class ChessException extends Exception {

    public ChessException() {
        super("You caused a chess Error.");
    }

    public ChessException(String errorMessage) {
        super(errorMessage);

    }

}
