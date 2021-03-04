package game;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.Movable;

/**
 * Mother class for all pieces of chessboard
 */

public abstract class Piece implements Movable {
    protected ChessBoard board;
    protected Coord pos;

    public void setCol(Color col) {
        this.col = col;
    }

    protected Color col;

    //Getter
    public Coord getPlace() { return pos; }
    public ChessBoard getBoard() { return board; }
    public Color getCol() { return col; }

    protected Piece(Coord pos, Color col, ChessBoard board) {
        this.board = board;
        this.col = col;
        this.pos = pos;

        this.board.setOccupation(this.pos, this);
    }

    public void move(Coord c) throws IllegalMove, IllegalPosition {
        if (c.getX() < 8 && c.getX() >= 0 && c.getY() < 8 && c.getY() >= 0 && !getBoard().isOccupied(c)) {
            if (isValidMove(c) == true) {
                this.board.setOccupation(c, this);// la piece
            } else {
                throw new IllegalMove("Illegal move for the Piece");
            }
        } else {
            throw new IllegalPosition("The Piece is out of range");

        }
    }

    public int sign(int i) {
        if (i > 0) {
            return 1;
        } else if (i < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean checkPath(Coord start, Coord end){
        int dx = sign(end.getX() - start.getX());
        int dy = sign(end.getY() - start.getY());

        for (Coord i = new Coord(start.getX() + 1 + dx, start.getY() + dy + 1); !((i.getX() == end.getX()) && (i.getY() == end.getY())); i.setX(i.getX() + dx), i.setY(i.getY() + dy)){
            if (this.board.isOccupied(i)) {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isValidMove(Coord c);

    @Override
    public Coord getPos() {
        return pos;
    }

    @Override
    public void setPos(Coord pos) {
        this.pos = pos;
    }
}

