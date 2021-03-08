package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

/**
 * A piece of chess : pawn
 */

public class Pawn extends Piece {
    /**
     *
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     */

    public Pawn(Coord pos, Color col, ChessBoard board) throws IllegalMove, IllegalPosition {
        super(pos, col, board);
    }

    /**
     *
     * @param c corresponds to the new desired position.
     * @throws IllegalPosition except an exception when the piece is out of matrix
     * @throws IllegalMove except an exception when  the piece make a move out of this capacity.
     */

    @Override
    protected boolean isValidMove(Coord c) {
        int dy = Math.abs(this.pos.getY() - c.getY());
        if(getCol() == Color.WHITE) {
            if ((c.getX() == this.pos.getX() + 1 && dy == 0) || (this.pos.getX() == 1 && c.getX() <= this.pos.getX() + 2 && dy == 0)){
                if (checkPath(this.pos, c)) {
                    return true;
                }
            }
        } else if(getCol() == Color.BLACK) {
            if ((c.getX() == this.pos.getX() - 1 && dy == 0) || (this.pos.getX() == 6 && c.getX() <= this.pos.getX() - 2 && dy == 0)) {
                if (checkPath(this.pos, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        if (col == Color.WHITE){
            return "♟";
        } else {
            return "♙";
        }
    }
}
