package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

/**
 * A piece of chess : knight
 */
public class Knight extends Piece {
    /**
     *
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     */

    public Knight(Coord pos, Color col, ChessBoard board) throws IllegalMove, IllegalPosition {
        super(pos, col, board);
    }

    /**
     *
     * @param c corresponds to the new desired position.
     * @throws IllegalPosition except an exception when the piece is out of matrix.
     * @throws IllegalMove except an exception when  the piece make a move out of this capacity.
     */
    @Override
    protected boolean isValidMove(Coord c) {
        int dx = Math.abs(this.pos.getX() - c.getX());
        int dy = Math.abs(this.pos.getY() - c.getY());

        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        if (col == Color.WHITE){
            return "♞";
        } else {
            return "♘";
        }
    }

}


