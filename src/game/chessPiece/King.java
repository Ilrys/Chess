package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    /**
     * A piece of chess : king
     * @param pos corresponds of the position's piece
     * @param col corresponds of tge color's piece
     * @param board corresponds of the board with de pieces
     * @throws IllegalPosition
     */
    public King(Coord pos, Color col, ChessBoard board) throws IllegalPosition {
        super(pos, col, board);
    }

    /**
     * This method check the rules of piece's trips.
     * @param c corresponds to the new desired position.
     * @return a boolean if move is possible or not
     */
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
            return "♚";
        } else {
            return "♔";
        }
    }
}
