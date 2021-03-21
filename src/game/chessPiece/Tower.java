package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {

    /**
     * A piece of chess : Tower
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     * @throws IllegalPosition
     */
    public Tower(Coord pos, Color col, ChessBoard board) throws IllegalPosition {
        super(pos, col, board);
    }

    /**
     * Method used to check if the number sign is positive, negative or null
     * @param i Integer to the sign
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

    /**
     * This method check the rules of piece's trips.
     * @param c corresponds to the new desired position.
     * @return a boolean if move is possible or not
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

    /**
     * Methods to determine if the move is legal or not
     * @return list of coord
     */
    @Override
    public List<Coord> legalMove(){
        ArrayList<Coord> coords = new ArrayList<Coord>();
        for(int i =0; i<8; i++){
            for(int j =0; j<8; j++){
                Coord co = new Coord(i+1,j+1);
                if(isValidMove(co)){
                    coords.add(co);
                }
            }
        }
        return coords;
    }

    /**
     * Methods which determine the appearance of this piece
     * @return image of piece
     */
    public String toString(){
        if (col == Color.WHITE){
            return "♜";
        } else {
            return "♖";
        }
    }
}
