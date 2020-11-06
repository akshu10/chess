package chess;

/**
 *
 * @author Parth Patel.
 *
 * Thrown when a piece tries to replace a piece with a similar color.
 *
 */
public class SelfCaptureException extends ChessException {

    public SelfCaptureException() {
        super("Self Capture");
    }

    public SelfCaptureException(String message) {
        super(message);
    }

}
