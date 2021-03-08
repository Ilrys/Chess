package game;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.Movable;

import java.io.Serializable;

public class ChessBoard implements Serializable {
    private Case[][] lesCases;
    private Color currentPlayer;
    private Case[][] getLesCases() {
        return lesCases;
    }

    /**
     * This method give the access of player
     */
    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Allow to change the payer (black or white)
     */
    public void changePlayer() {
        if (this.currentPlayer == Color.WHITE){
            this.currentPlayer = Color.BLACK;
        } else {
            this.currentPlayer = Color.WHITE;
        }
    }

    /**
     * The constructor of the chessboard
     */
    public ChessBoard() {
        this.lesCases = new Case[8][8];
        this.currentPlayer = Color.WHITE;
        for(int i = 0; i<8; i++){
            for( int j = 0; j<8; j++){
                lesCases[i][j] = new Case();
            }
        }
    }

    /**
     * Define if the position is occupied
     * @param pos represents a specific position in matrix.
     * @return a boolean, true if the case is occupied else false.
     */

    public boolean isOccupied(Coord pos){
        return this.lesCases[pos.getX()][pos.getY()].isOccupied();
    }

    /**
     * this method allows access to chess pieces if the case is not occupied.
     * @param pi
     * @return
     */
    public Piece getPieces(Coord pi) {
        if (isOccupied(pi)) {
            return (Piece) this.lesCases[pi.getX()][pi.getY()].getPiece();
        } else {
            System.out.print("La case est vide");
        }
        return null;
    }
    /**
     * Set if the position in the matrix is occupied or not
     * @param pos represents a specific position in matrix.
     * @param p  Boolean value to set if the position is occupied or not.
     */

    public void setOccupation(Coord pos, Movable p) throws IllegalPosition {
        if (pos.getX() < 8 && pos.getX() >= 0 && pos.getY() < 8 && pos.getY() >= 0 ){
            lesCases[pos.getX()][pos.getY()].setPiece(p);
        } else {
            throw new IllegalPosition("The Piece is out of range");
        }
    }

    /**
     * The visual matrix for interface
     */

    public void smartPrint(){
        System.out.println("");
        for(int i = 8; i>0; i--){ // évite l'inversion d'affichage
            System.out.print(i);
            for( int j = 0; j<8; j++){
                if(this.lesCases[i-1][j].isOccupied() == true) {
                    System.out.print(" " + this.lesCases[i-1][j].getPiece() + " ");
                }else{
                    System.out.print(" □ ");
                }
            }
            System.out.println("");
        }
        System.out.print("  1  2  3  4  5  6  7  8");

    }
}
