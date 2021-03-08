package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

/**
 * A piece of chess : king
 */
public class King extends Piece {

    /**
     *
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     */
    public King(Coord pos, Color col, ChessBoard board) throws IllegalMove, IllegalPosition {
        super(pos, col, board);
    }

    // add 24/02/21
    @Override
    protected boolean isValidMove(Coord c) {
        int dx = Math.abs(this.pos.getX() - c.getX());
        int dy = Math.abs(this.pos.getY() - c.getY());

        if((dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dx == 1 && dy == 1)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        if (col == Color.WHITE){
            return "♛";
        } else {
            return "♕";
        }
    }
}
