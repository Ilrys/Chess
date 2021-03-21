package game;

import appli.TP2ex1;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.King;
import game.chessPiece.Movable;

import java.io.Serializable;
import java.util.List;

/**
 * Mother class for all pieces of chessboard
 */

public abstract class Piece implements Movable, Serializable {
    protected ChessBoard board;
    protected Coord pos;
    protected Color col;

    // Setter
    public void setCol(Color col) {
        this.col = col;
    }
    @Override
    public void setPos(Coord pos) { this.pos = pos; }

    //Getter
    public Coord getPlace() { return pos; }
    public ChessBoard getBoard() { return board; }
    public Color getCol() { return col; }
    @Override
    public Coord getPos() { return pos; }

    /**
     * This method init the pieces
     * @param pos Init the position of piece
     * @param col Init color of piece
     * @param board Init the board of chess
     */
    protected Piece(Coord pos, Color col, ChessBoard board) throws IllegalPosition {
        this.board = board;
        this.col = col;
        this.pos = pos;
        this.board.setOccupation(this.pos, this);
    }

    /**
     * This function realized the movement of pieces
     * @param c the initial position of piece
     * @throws IllegalMove
     * @throws IllegalPosition
     */
    public void move(Coord c) throws IllegalMove, IllegalPosition {
        if(board.getPieces(c) instanceof King){
            TP2ex1.finish();
        }
        if (isValidMove(c) == true) {
            if(board.isOccupied(c)) {
                if (getCol() != board.getPieces(c).getCol()) {
                    this.board.setOccupation(pos, null);
                    setPos(c);
                    this.board.setOccupation(c, this);// the piece
                } else {
                    throw new IllegalMove("You can't eat our own clan");
                }
            } else {
                this.board.setOccupation(pos, null);
                setPos(c);
                this.board.setOccupation(c, this);// the piece
            }
        } else {
            throw new IllegalMove("Illegal move for the Piece");
        }
    }

    /**
     * Method used to check if the number sign is positive, negative or null
     * @param i Integer to the sign
     * @return return the sign of position
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
     * This function check if there are a piece on the way
     * @param start The beginning position
     * @param end The last position
     * @return a boolean if the path is correct or not
     */
    public boolean checkPath(Coord start, Coord end){
        int dx = sign(end.getX() - start.getX());
        int dy = sign(end.getY() - start.getY());

        for (Coord i = new Coord(start.getX() + dx + 1, start.getY() + dy + 1); !((i.getX() == end.getX()) && (i.getY() == end.getY())); i.setX(i.getX() + dx), i.setY(i.getY() + dy)){
            if (this.board.isOccupied(i)) {
                return false;
            }
        }
        if (board.isOccupied(end)){
            Piece arrivalPiece = (Piece) board.getPieces(end);
            if (arrivalPiece.getCol() == this.getCol()){
                return false;
            }
        }
        return true;
    }

    public abstract List<Coord> legalMove();
    protected abstract boolean isValidMove(Coord c);
}

