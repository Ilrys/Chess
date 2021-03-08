package game;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.Movable;

import java.io.Serializable;

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

    //Getter
    public Coord getPlace() { return pos; }
    public ChessBoard getBoard() { return board; }
    public Color getCol() { return col; }

    /**
     * This method init the pieces
     * @param pos Init the position of piece
     * @param col Init color of piece
     * @param board Init the board of chess
     */
    protected Piece(Coord pos, Color col, ChessBoard board) throws IllegalMove, IllegalPosition {
        this.board = board;
        this.col = col;
        this.pos = pos;

        this.board.setOccupation(this.pos, this);
    }

    /**
     *
     * @param c
     * @throws IllegalMove
     * @throws IllegalPosition
     */
    public void move(Coord c) throws IllegalMove, IllegalPosition {
        if (isValidMove(c) == true) {
            System.out.print(board.getCurrentPlayer());
            System.out.print(board.isOccupied(c));

            if(board.isOccupied(c)) {
                if (getCol() != board.getPieces(c).getCol()) {
                    this.board.setOccupation(pos, null);
                    setPos(c);
                    this.board.setOccupation(c, this);// la piece
                } else {
                    throw new IllegalMove("You can't eat our own clan");
                }
            } else {
                this.board.setOccupation(pos, null);
                setPos(c);
                this.board.setOccupation(c, this);// la piece
            }
        } else {
            throw new IllegalMove("Illegal move for the Piece");
        }
    }

    /**
     *
     * @param i
     * @return
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
     *
     * @param start
     * @param end
     * @return
     */
    public boolean checkPath(Coord start, Coord end){
        int dx = sign(end.getX() - start.getX());
        int dy = sign(end.getY() - start.getY());

        for (Coord i = new Coord(start.getX() + dx + 1, start.getY() + dy + 1); !((i.getX() == end.getX()) && (i.getY() == end.getY())); i.setX(i.getX() + dx), i.setY(i.getY() + dy)){
            if (this.board.isOccupied(i)) {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isValidMove(Coord c);
    /**
     *
     * @return
     */
    @Override
    public Coord getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    @Override
    public void setPos(Coord pos) {
        this.pos = pos;
    }
}

