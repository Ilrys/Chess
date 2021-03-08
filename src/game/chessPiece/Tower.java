package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

/**
 * A piece of chess : tower
 */
public class Tower extends Piece {

    /**
     *
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     */

    /**
     * Method used to check if the number sign is positive, negative or null
     * @param i Integer
     */
    public int sign(int i) {
        if (i > 0) {
            return 1;
        } else if (i < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public Tower(Coord pos, Color col, ChessBoard board) throws IllegalMove, IllegalPosition {
        super(pos, col, board);
    }

    /**
     * This method check the rules of piece's trips. 
     * @param c corresponds to the new desired position.
     * @throws IllegalPosition except an exception when the piece is out of matrix
     * @throws IllegalMove except an exception when  the piece make a move out of this capacity.
     */

    @Override
    protected boolean isValidMove(Coord c) {
        if ((c.getX() != pos.getX()) && (c.getY() == pos.getY())||(c.getX() == pos.getX())&&(c.getY() != pos.getY())){
            if(checkPath(this.pos , c)) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        if (col == Color.WHITE){
            return "♜";
        } else {
            return "♖";
        }
    }
}
