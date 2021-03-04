package appli;

import game.*;

import java.util.Scanner;
import java.util.ArrayList;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.*;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;

import static game.Color.*;

public class TP2ex1 {

    public static void main(String[] args) {
        System.out.print("- Entrez J pour jouer \n- Entrez R pour revoir la dernière partie \nChoix : ");
        Scanner scan = new Scanner(System.in);
        String beginChoice= "";
        beginChoice = scan.nextLine();
        System.out.println("String read from console is : " + beginChoice);

        ArrayList<String> positions = new ArrayList<String>();
        Boolean isFinish = false;
        String inputString= "";
        Color currentPlayer = WHITE;

        ChessBoard myChess = new ChessBoard();

        // My whites pieces
        King myKingW = new King(new Coord(1,4), WHITE, myChess);
        Queen myQueenW = new Queen(new Coord(1,5), WHITE, myChess);
        Tower myTowerW1 = new Tower(new Coord(1,1), WHITE, myChess);
        Tower myTowerW2 = new Tower(new Coord(1,8), WHITE, myChess);
        Bishop myBishopW1 = new Bishop(new Coord(1,3), WHITE, myChess);
        Bishop myBishopW2 = new Bishop(new Coord(1,6), WHITE, myChess);
        Knight myKnightW1 = new Knight(new Coord(1,2), WHITE, myChess);
        Knight myKnightW2 = new Knight(new Coord(1,7), WHITE, myChess);
        Pawn myPawnW1 = new Pawn(new Coord(2,1), WHITE, myChess);
        Pawn myPawnW2 = new Pawn(new Coord(2,2), WHITE, myChess);
        Pawn myPawnW3 = new Pawn(new Coord(2,3), WHITE, myChess);
        Pawn myPawnW4 = new Pawn(new Coord(2,4), WHITE, myChess);
        Pawn myPawnW5 = new Pawn(new Coord(2,5), WHITE, myChess);
        Pawn myPawnW6 = new Pawn(new Coord(2,6), WHITE, myChess);
        Pawn myPawnW7 = new Pawn(new Coord(2,7), WHITE, myChess);
        Pawn myPawnW8 = new Pawn(new Coord(2,8), WHITE, myChess);

        // My blacks pieces
        King myKingB = new King(new Coord(8,4), BLACK, myChess);
        Queen myQueenB = new Queen(new Coord(8,5), BLACK, myChess);
        Tower myTowerB1 = new Tower(new Coord(8,1), BLACK, myChess);
        Tower myTowerB2 = new Tower(new Coord(8,8), BLACK, myChess);
        Bishop myBishopB1 = new Bishop(new Coord(8,3), BLACK, myChess);
        Bishop myBishopB2 = new Bishop(new Coord(8,6), BLACK, myChess);
        Knight myKnightB1 = new Knight(new Coord(8,2), BLACK, myChess);
        Knight myKnightB2 = new Knight(new Coord(8,7), BLACK, myChess);
        Pawn myPawnB1 = new Pawn(new Coord(7,1), BLACK, myChess);
        Pawn myPawnB2 = new Pawn(new Coord(7,2), BLACK, myChess);
        Pawn myPawnB3 = new Pawn(new Coord(7,3), BLACK, myChess);
        Pawn myPawnB4 = new Pawn(new Coord(7,4), BLACK, myChess);
        Pawn myPawnB5 = new Pawn(new Coord(7,5), BLACK, myChess);
        Pawn myPawnB6 = new Pawn(new Coord(7,6), BLACK, myChess);
        Pawn myPawnB7 = new Pawn(new Coord(7,7), BLACK, myChess);
        Pawn myPawnB8 = new Pawn(new Coord(7,8), BLACK, myChess);

        //Initial Chess
        myChess.smartPrint();
        System.out.println("");

        if(beginChoice.equals("J")){
            // Black and White
            while(isFinish == false) {
                // Enter position
                System.out.print("- Enter a position \n- F to finish \n- S to save \n-> ");
                Scanner scanner = new Scanner(System.in);
                inputString = scanner.nextLine();
                System.out.println("String read from console is : " + inputString);

                if (inputString.equals("F")) {
                    // end game
                    System.out.println("Le jeu est terminé");
                    isFinish = true;
                }else if((inputString.equals("S"))){
                    try {
                        FileOutputStream fileOut = new FileOutputStream("saveGame.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(myChess);
                        out.close();
                        fileOut.close();
                        System.out.printf("Serialized data is saved in saveGame.ser");
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                } else {
                    try {
                        // create position
                        String[] parts = inputString.split(" ");
                        String[] initPositions = parts[0].split(""); // Initial position
                        String[] lastPositions = parts[1].split(""); // Final position
                        System.out.println("InitPosition is  : " + initPositions[0]);

                        // Move Pieces
                        Coord mycord = new Coord(Integer.parseInt(initPositions[0]), Integer.parseInt(initPositions[1]));

                        if (currentPlayer == myChess.getPieces(mycord).getCol()) {
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

                        for (String str : positions) {
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
        } else if(beginChoice.equals("R")){
            String chaine="";
            String fichier ="game.txt";

            try{
                InputStream game = new FileInputStream(fichier);
                InputStreamReader gameReader = new InputStreamReader(game);
                BufferedReader reader = new BufferedReader(gameReader);
                String ligne;
                while ((ligne = reader.readLine())!=null){
                    System.out.println(ligne);
                    chaine+=ligne+"\n";
                    try {
                        // create position
                        String[] parts = ligne.split(" ");
                        String[] initPositions = parts[0].split(""); // Initial position
                        String[] lastPositions = parts[1].split(""); // Final position
                        System.out.println("InitPosition is  : " + initPositions[0]);

                        // Move Pieces
                        Coord mycord = new Coord(Integer.parseInt(initPositions[0]), Integer.parseInt(initPositions[1]));

                        if (currentPlayer == myChess.getPieces(mycord).getCol()) {
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
                    myChess.smartPrint();
                    System.out.println("");
                }
                reader.close();
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        } else{
            System.out.println("Veuillez choisir l'une des options proposées");
        }
    }

}
