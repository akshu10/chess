package chess;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Parth Patel. This Class is complete and working as per requirement.
 *
 */
public class Board {

    protected Piece[][] pieces;
    // True for whites turn.
    protected boolean isWhiteTurn;

    /**
     * Defines a board Object which contains an array Of Piece Objects.
     */
    public Board() {

        isWhiteTurn = true;

        pieces = new Piece[8][8];

        //Creating Black Chess Pieces
        //Assigning starting positions to the Pieces in the Array. 
        pieces[0][0] = new Rook(this, false, 1, 1);
        pieces[1][0] = new Knight(this, false, 2, 1);
        pieces[2][0] = new Bishop(this, false, 3, 1);
        pieces[3][0] = new Queen(this, false, 4, 1);
        pieces[4][0] = new King(this, false, 5, 1);
        pieces[5][0] = new Bishop(this, false, 6, 1);
        pieces[6][0] = new Knight(this, false, 7, 1);
        pieces[7][0] = new Rook(this, false, 8, 1);

        // Creating Black Pawn Pieces. 
        //Assigning all pawn Objects starting positions on the Array. 
        for (int i = 0; i < 8; i++) {
            pieces[i][1] = new Pawn(this, false, (i + 1), 2);

        }

        // Creating White Pieces
        //Assigning starting positions to white Pieces
        pieces[0][7] = new Rook(this, true, 1, 8);
        pieces[1][7] = new Knight(this, true, 2, 8);
        pieces[2][7] = new Bishop(this, true, 3, 8);
        pieces[3][7] = new Queen(this, true, 4, 8);
        pieces[4][7] = new King(this, true, 5, 8);
        pieces[5][7] = new Bishop(this, true, 6, 8);
        pieces[6][7] = new Knight(this, true, 7, 8);
        pieces[7][7] = new Rook(this, true, 8, 8);

        // Creating White Pawn Pieces.
        //Assigning Pawn Objects Starting Positions.
        for (int i = 0; i < 8; i++) {
            pieces[i][6] = new Pawn(this, true, (i + 1), 7);

        }

    }

    /**
     * Displays the chess board and the Initial Positions of the Pieces.
     * //Displays the Positions even after the, move method is called and a
     * Piece is moved.
     *
     */
    public void display() {

        System.out.println();

        System.out.print("    ");
        for (int i = 1; i < 9; i++) {

            System.out.print(i + "   ");
        }
        System.out.println();
        int k = 1;
        for (int row = 0; row < 8; row++) {

            System.out.print("  " + "---------------------------------");
            System.out.println("");
            System.out.print(k + " ");
            for (int column = 0; column < 8; column++) {
                if (pieces[column][row] == null) {
                    System.out.print("|" + "   ");

                } else {
                    System.out.print("| "
                            + pieces[column][row].getSymbol() + " ");
                }

            }
            System.out.print("|");
            System.out.println();
            k++;
        }
        System.out.print("  " + "---------------------------------");
        System.out.println();
        System.out.println();

    }

    /**
     * This Display method is Called when a ChessException Does not Occur.
     *
     * @param out PrintWriter Object.
     * @param fileName Name of the File the PrintWriter object will write too.
     * @param x1 Initial Column Position of any piece
     * @param y1 Initial Row Position of any piece.
     * @param x2 Column Position a piece is to be moved too.
     * @param y2 Row position a piece is to be moved too.
     * @throws IOException
     */
    public void display(PrintWriter out, String fileName,
            int x1, int y1, int x2, int y2) throws IOException {

        //Creates a Scanner Object.
        Scanner kbd = new Scanner(System.in);

        try {
            out = new PrintWriter(new FileOutputStream(fileName, true));
            out.println();
            out.print("    ");
            for (int i = 1; i < 9; i++) {

                out.print(i + "   ");
            }
            out.println();
            int k = 1;
            for (int row = 0; row < 8; row++) {

                out.print("  " + "---------------------------------");
                out.println("");
                out.print(k + " ");
                for (int column = 0; column < 8; column++) {
                    if (pieces[column][row] == null) {
                        out.print("|" + "   ");

                    } else {
                        out.print("| "
                                + pieces[column][row].getSymbol() + " ");
                    }

                }
                out.print("|");
                out.println();
                k++;
            }
            out.print("  " + "---------------------------------");
            out.println();
            out.println();
            out.println("Move: " + x1 + " " + y1 + " to "
                    + x2 + " " + y2);

        } finally {
            if (out != null) {
                out.close();

            }
        }

    }

    /**
     * This Display method is Called when a ChessException Does Occur.
     *
     * @param out PrintWriter Object. //@param fileName Name of the File the
     * PrintWriter object will write too.
     * @param fileName
     * @param x1 Initial Column Position of any piece
     * @param y1 Initial Row Position of any piece.
     * @param x2 Column Position a piece is to be moved too.
     * @param y2 Row position a piece is to be moved too.
     * @param e ChessException is passed from the Driver to the Board class so
     * it be Displayed.
     * @throws IOException
     */
    public void display(PrintWriter out, String fileName,
            int x1, int y1, int x2, int y2, ChessException e) throws IOException {
//       Scanner kbd = new Scanner(System.in);

        try {
            out = new PrintWriter(new FileOutputStream(fileName, true));
            out.println();
            out.print("    ");
            for (int i = 1; i < 9; i++) {

                out.print(i + "   ");
            }
            out.println();
            int k = 1;
            for (int row = 0; row < 8; row++) {

                out.print("  " + "---------------------------------");
                out.println("");
                out.print(k + " ");
                for (int column = 0; column < 8; column++) {
                    if (pieces[column][row] == null) {
                        out.print("|" + "   ");

                    } else {
                        out.print("| "
                                + pieces[column][row].getSymbol() + " ");
                    }

                }
                out.print("|");
                out.println();
                k++;
            }
            out.print("  " + "---------------------------------");
            out.println();
            out.println();
            out.println("Move: " + x1 + " " + y1 + " to "
                    + x2 + " " + y2);
            out.println(e);

        } finally {
            if (out != null) {
                out.close();

            }
        }
    }

    /**
     *
     * @param x1 - Initial Column position of the Piece.
     * @param y1 - Initial Row position of the Piece.
     * @param x2 - Piece is to be moved to this Column on the Board.
     * @param y2 - Piece is to be moved to this Row on the Board.
     *
     * @throws chess.OffBoardException - If the Coordinates are not on the
     * Board.
     * @throws chess.NoPieceException - If the Coordinates to be moved from have
     * no piece to move.
     * @throws chess.WrongTurnException - If the Pieces isValidMove method
     * returns false.
     * @throws chess.SelfCaptureException
     * @throws chess.InvalidMoveException
     *
     */
    /*
     * Checks if the Coordinates passed are on the Board. 
     * Checks if the Coordinates passed have a piece to be moved.
     * If all conditions are valid, then that piece is used to call the
     * move method of the Piece Class.
     * Thereafter that position on the board is nulled.
    
     */
    public void move(int x1, int y1, int x2, int y2) throws OffBoardException,
            NoPieceException, WrongTurnException, SelfCaptureException,
            InvalidMoveException {

        /*
         *
         * Checks if the Coordinates are on the Board. If not throws an
         * OffBoardException.
         */
        if ((x1 <= 0 || x1 > 8) || (y1 <= 0 || y1 > 8)
                || (x2 <= 0 || x2 > 8) || (y2 <= 0 || y2 > 8)) {
            throw new OffBoardException(
                    "At least one coordinate was invalid.");

        }

        /*
         * Checking the coordinates if they have a Piece. If the don't a
         * NoPieceException is thrown.
         *
         */
        if (pieces[x1 - 1][y1 - 1] == null) {
            throw new NoPieceException(
                    " There is no piece at " + x1 + " " + y1);

        }

        /*
         * Checks if the the user moves a piece with different color every time.
         * else throws a WrongTurnException.
         *
         * Catches InvalidMoveException and deals with it.
         *
         */
        if (getIsWhiteTurn() == pieces[x1 - 1][y1 - 1].color) {

            if (pieces[x2 - 1][y2 - 1] == null) {

                try {
                    pieces[x1 - 1][y1 - 1].move(x2, y2);
                    pieces[x1 - 1][y1 - 1] = null;

                } catch (InvalidMoveException e) {
                    throw e;
                }
            } else if (pieces[x1 - 1][y1 - 1].color
                    == pieces[x2 - 1][y2 - 1].color) {

                if (getIsWhiteTurn()) {
                    throw new SelfCaptureException("There is already a "
                            + "White piece there.");

                } else {
                    throw new SelfCaptureException("There is already a "
                            + "Black piece there.");
                }

            } else {
                try {
                    pieces[x1 - 1][y1 - 1].move(x2, y2);
                    pieces[x1 - 1][y1 - 1] = null;

                } catch (InvalidMoveException e) {
                    throw e;

                }

            }

        } else {

            if (getIsWhiteTurn()) {
                throw new WrongTurnException("It is not Black's turn to move.");

            } else {
                throw new WrongTurnException("It is not White's turn to move.");
            }
        }

    }

    /**
     *
     * @return True if its white colors turn.
     */
    public boolean getIsWhiteTurn() {
        if (isWhiteTurn) {
            return true;

        } else {
            return false;
        }
    }

}
