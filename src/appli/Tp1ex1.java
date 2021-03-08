package appli;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.*;

import static game.Color.*;

public class Tp1ex1 {
    /**
     *
     * @param args an array argument used with the console.
     */

    public static void main(String[] args) throws IllegalMove, IllegalPosition {
        ChessBoard myChess = new ChessBoard();

        // Initial positions white pawn
        Coord coordTowerW1= new Coord(1,1);
        Coord coordKnightW1= new Coord(1, 2);
        Coord coordBishopW2= new Coord(1, 3);
        Coord coordKingW = new Coord(1,4);
        Coord coordQueenW = new Coord(1,5);
        Coord coordBishopW1= new Coord(1, 6);
        Coord coordKnightW2= new Coord(1, 7);
        Coord coordTowerW2= new Coord(1,8);

        // Initial positions black pawn
        Coord coordTowerB1= new Coord(8,1);
        Coord coordKnightB1= new Coord(8, 2);
        Coord coordBishopB2= new Coord(8, 3);
        Coord coordKingB = new Coord(8,4);
        Coord coordQueenB = new Coord(8,5);
        Coord coordBishopB1= new Coord(8, 6);
        Coord coordKnightB2= new Coord(8, 7);
        Coord coordTowerB2= new Coord(8,8);

        // Whites pawns
        Coord coordPawnW1= new Coord(2, 1);
        Coord coordPawnW2= new Coord(2, 2);
        Coord coordPawnW3= new Coord(2, 3);
        Coord coordPawnW4= new Coord(2, 4);
        Coord coordPawnW5= new Coord(2, 5);
        Coord coordPawnW6= new Coord(2, 6);
        Coord coordPawnW7= new Coord(2, 7);
        Coord coordPawnW8= new Coord(2, 8);

        //Blacks Pawns
        Coord coordPawnB1= new Coord(7, 1);
        Coord coordPawnB2= new Coord(7, 2);
        Coord coordPawnB3= new Coord(7, 3);
        Coord coordPawnB4= new Coord(7, 4);
        Coord coordPawnB5= new Coord(7, 5);
        Coord coordPawnB6= new Coord(7, 6);
        Coord coordPawnB7= new Coord(7, 7);
        Coord coordPawnB8= new Coord(7, 8);

        // My whites pieces
        King myKingW = new King(coordKingW, WHITE, myChess);
        Queen myQueenW = new Queen(coordQueenW, WHITE, myChess);
        Tower myTowerW1 = new Tower(coordTowerW1, WHITE, myChess);
        Tower myTowerW2 = new Tower(coordTowerW2, WHITE, myChess);
        Bishop myBishopW1 = new Bishop(coordBishopW1, WHITE, myChess);
        Bishop myBishopW2 = new Bishop(coordBishopW2, WHITE, myChess);
        Knight myKnightW1 = new Knight(coordKnightW1, WHITE, myChess);
        Knight myKnightW2 = new Knight(coordKnightW2, WHITE, myChess);
        Pawn myPawnW1 = new Pawn(coordPawnW1, WHITE, myChess);
        Pawn myPawnW2 = new Pawn(coordPawnW2, WHITE, myChess);
        Pawn myPawnW3 = new Pawn(coordPawnW3, WHITE, myChess);
        Pawn myPawnW4 = new Pawn(coordPawnW4, WHITE, myChess);
        Pawn myPawnW5 = new Pawn(coordPawnW5, WHITE, myChess);
        Pawn myPawnW6 = new Pawn(coordPawnW6, WHITE, myChess);
        Pawn myPawnW7 = new Pawn(coordPawnW7, WHITE, myChess);
        Pawn myPawnW8 = new Pawn(coordPawnW8, WHITE, myChess);

        // My blacks pieces
        King myKingB = new King(coordKingB, BLACK, myChess);
        Queen myQueenB = new Queen(coordQueenB, BLACK, myChess);
        Tower myTowerB1 = new Tower(coordTowerB1, BLACK, myChess);
        Tower myTowerB2 = new Tower(coordTowerB2, BLACK, myChess);
        Bishop myBishopB1 = new Bishop(coordBishopB1, BLACK, myChess);
        Bishop myBishopB2 = new Bishop(coordBishopB2, BLACK, myChess);
        Knight myKnightB1 = new Knight(coordKnightB1, BLACK, myChess);
        Knight myKnightB2 = new Knight(coordKnightB2, BLACK, myChess);
        Pawn myPawnB1 = new Pawn(coordPawnB1, BLACK, myChess);
        Pawn myPawnB2 = new Pawn(coordPawnB2, BLACK, myChess);
        Pawn myPawnB3 = new Pawn(coordPawnB3, BLACK, myChess);
        Pawn myPawnB4 = new Pawn(coordPawnB4, BLACK, myChess);
        Pawn myPawnB5 = new Pawn(coordPawnB5, BLACK, myChess);
        Pawn myPawnB6 = new Pawn(coordPawnB6, BLACK, myChess);
        Pawn myPawnB7 = new Pawn(coordPawnB7, BLACK, myChess);
        Pawn myPawnB8 = new Pawn(coordPawnB8, BLACK, myChess);

        //Initial Chess
        myChess.smartPrint();
        System.out.println("");

        try{
            // My news positions
            Coord myCoordPawnW1 = new Coord(4,1);
            myPawnW1.move(myCoordPawnW1);
            Coord myQueenPawnB = new Coord(9,5);
            myQueenB.move(myQueenPawnB);
        } catch (IllegalPosition e){
            System.out.println(e);
        } catch (IllegalMove e){
            System.out.println(e);
        }
        myChess.smartPrint();

    }
 }

