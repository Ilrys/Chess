package game;

import game.chessPiece.King;
import game.chessPiece.Movable;

public class ChessBoard {
    Case lesCases[][];

    /**
     * The constructor of the chessboard
     */

    public ChessBoard() {
        lesCases = new Case[8][8];

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
     * Set if the position in the matrix is occupied or not
     * @param pos represents a specific position in matrix.
     * @param p  Boolean value to set if the position is occupied or not.
     */

    public void setOccupation(Coord pos, Movable p){
        // REMPLACER
        lesCases[p.getPos().getX()][p.getPos().getY()].setPiece(null);
        lesCases[pos.getX()][pos.getY()].setPiece(p);
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
