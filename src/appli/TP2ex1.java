package appli;

import game.*;

import java.util.Scanner;
import java.util.ArrayList;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import static game.Color.*;

public class TP2ex1 {

    public static void main(String[] args) {
        ArrayList<String> positions = new ArrayList<String>();
        Boolean isFinish = false;
        String inputString= "";
        Color currentPlayer = WHITE;

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

        // Black and White
        while(isFinish == false) {
            // Enter position
            System.out.print("Enter a position OR F to finish");
            Scanner scanner = new Scanner(System.in);
            inputString = scanner.nextLine();
            System.out.println("String read from console is : " + inputString);

            if(inputString.equals("F")) {
                // end game
                System.out.println("Le jeu est terminé");
                isFinish = true;
            } else {
                try {
                    // create position
                    String[] parts = inputString.split(" ");
                    String[] initPositions = parts[0].split(""); // Initial position
                    String[] lastPositions = parts[1].split(""); // Final position
                    System.out.println("InitPosition is  : " + initPositions[0]);

                    // Move Pieces
                    Coord mycord = new Coord(Integer.parseInt(initPositions[0]),Integer.parseInt(initPositions[1]));

                    if (currentPlayer == myChess.getPieces(mycord).getCol()){
                        Movable changingPiece = myChess.getPieces(mycord);
                        changingPiece.move(new Coord(Integer.parseInt(lastPositions[0]), Integer.parseInt(lastPositions[1])));
                        positions.add(inputString);
                        currentPlayer = BLACK;

                    } else {
                        System.out.println("Essayez une piece " + currentPlayer);
                    }

                } catch (IllegalPosition e) {
                    System.out.println(e);
                } catch (IllegalMove e) {
                    System.out.println(e);
                }
                System.out.println(positions);
                FileWriter monFichier = null;

                try {
                    monFichier = new FileWriter("game.txt");

                    for (String str: positions) {
                        // Ecrit le tableau de chaînes dans scores.txt
                        monFichier.write(str + System.lineSeparator());

                        System.out.println("Ecriture de : " + str + System.lineSeparator());
                    }
                    System.out.println("Ecriture du fichier terminée.");

                } catch (IOException exception) {
                    exception.printStackTrace();
                } finally {
                    try {
                        monFichier.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                myChess.smartPrint();
                System.out.println("");
            }
        }
    }

    public void replay(){

    }

}
