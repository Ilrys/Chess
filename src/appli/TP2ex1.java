package appli;

import fx.GraphFX;
import fx.Pictures;
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
    static Boolean isFinish = false;

    /**
     * this method allows to display a menu and to take actions.
     * @param args an array argument used with the console.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalMove, IllegalPosition {
        System.out.print("- Enter J to play \n- Enter R review the last game \n- Enter L to load saved game\n Choice : ");
        Scanner scan = new Scanner(System.in);
        String beginChoice = "";
        beginChoice = scan.nextLine();

        ArrayList<String> positions = new ArrayList<String>();
        String inputString = "";

        ChessBoard myChess = new ChessBoard();

        // My whites pieces
        King myKingW = new King(new Coord(1, 5), WHITE, myChess);
        Queen myQueenW = new Queen(new Coord(1, 4), WHITE, myChess);
        Tower myTowerW1 = new Tower(new Coord(1, 1), WHITE, myChess);
        Tower myTowerW2 = new Tower(new Coord(1, 8), WHITE, myChess);
        Bishop myBishopW1 = new Bishop(new Coord(1, 3), WHITE, myChess);
        Bishop myBishopW2 = new Bishop(new Coord(1, 6), WHITE, myChess);
        Knight myKnightW1 = new Knight(new Coord(1, 2), WHITE, myChess);
        Knight myKnightW2 = new Knight(new Coord(1, 7), WHITE, myChess);

        //for (int i = 1; i < 9; i++) {
          //  Pawn myPawnW1 = new Pawn(new Coord(2, i), WHITE, myChess);
        //}

        Pawn myPawnW1 = new Pawn(new Coord(2, 1), WHITE, myChess);
        Pawn myPawnW2 = new Pawn(new Coord(2, 2), WHITE, myChess);
        Pawn myPawnW3 = new Pawn(new Coord(2, 3), WHITE, myChess);
        Pawn myPawnW4 = new Pawn(new Coord(2, 4), WHITE, myChess);
        Pawn myPawnW5 = new Pawn(new Coord(2, 5), WHITE, myChess);
        Pawn myPawnW6 = new Pawn(new Coord(2, 6), WHITE, myChess);
        Pawn myPawnW7 = new Pawn(new Coord(2, 7), WHITE, myChess);
        Pawn myPawnW8 = new Pawn(new Coord(2, 8), WHITE, myChess);
        // My blacks pieces
        King myKingB = new King(new Coord(8, 5), BLACK, myChess);
        Queen myQueenB = new Queen(new Coord(8, 4), BLACK, myChess);
        Tower myTowerB1 = new Tower(new Coord(8, 1), BLACK, myChess);
        Tower myTowerB2 = new Tower(new Coord(8, 8), BLACK, myChess);
        Bishop myBishopB1 = new Bishop(new Coord(8, 3), BLACK, myChess);
        Bishop myBishopB2 = new Bishop(new Coord(8, 6), BLACK, myChess);
        Knight myKnightB1 = new Knight(new Coord(8, 2), BLACK, myChess);
        Knight myKnightB2 = new Knight(new Coord(8, 7), BLACK, myChess);
        Pawn myPawnB1 = new Pawn(new Coord(7, 1), BLACK, myChess);
        Pawn myPawnB2 = new Pawn(new Coord(7, 2), BLACK, myChess);
        Pawn myPawnB3 = new Pawn(new Coord(7, 3), BLACK, myChess);
        Pawn myPawnB4 = new Pawn(new Coord(7, 4), BLACK, myChess);
        Pawn myPawnB5 = new Pawn(new Coord(7, 5), BLACK, myChess);
        Pawn myPawnB6 = new Pawn(new Coord(7, 6), BLACK, myChess);
        Pawn myPawnB7 = new Pawn(new Coord(7, 7), BLACK, myChess);
        Pawn myPawnB8 = new Pawn(new Coord(7, 8), BLACK, myChess);

        //Initial Chess
        myChess.smartPrint();
        System.out.println("");

        if (beginChoice.equals("J")) {

            while (!isFinish) {
                // Enter position
                GraphFX.launch(GraphFX.class, args);

                myPawnB1.legalMove();
                myPawnB2.legalMove();

                myQueenW.legalMove();
                myTowerW2.legalMove();
                System.out.println("It's at " + myChess.getCurrentPlayer() + " to play");
                System.out.print("- Enter a position \n- F to finish \n- S to save \n-> ");
                Scanner scanner = new Scanner(System.in);
                inputString = scanner.nextLine();
                if (inputString.equals("F")) {
                    finish();
                } else if ((inputString.equals("S"))) {
                    save(myChess);
                } else {
                    positions.add(inputString);
                    play(myChess, inputString);
                    writer(positions);
                    System.out.println(positions);
                }
            }
        } else if (beginChoice.equals("L")) {
            myChess = load();
            System.out.println("Player turn : " + myChess.getCurrentPlayer());
            myChess.smartPrint();
            System.out.println("");
            while (isFinish == false) {
                // Enter position
                System.out.println("It's at " + myChess.getCurrentPlayer() + " to play");
                System.out.print("- Enter a position \n- F to finish \n- S to save \n-> ");
                Scanner scanner = new Scanner(System.in);
                inputString = scanner.nextLine();

                if (inputString.equals("F")) {
                    finish();
                } else if ((inputString.equals("S"))) {
                    save(myChess);
                } else {
                    play(myChess, inputString);
                }
            }
        } else if (beginChoice.equals("R")) {
            String chaine = "";
            String fichier = "game.txt";

            try {
                InputStream game = new FileInputStream(fichier);
                InputStreamReader gameReader = new InputStreamReader(game);
                BufferedReader reader = new BufferedReader(gameReader);
                String ligne;

                while ((ligne = reader.readLine()) != null) {
                    System.out.println(ligne);
                    chaine += ligne + "\n";
                    play(myChess, ligne);
                    myChess.smartPrint();
                    System.out.println("");
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Please choose one of the following options");
        }
    }

    /**
     * This method allow to save all the positions of the game in a file text.
     * @param positions list of positions of pieces
     */
    public static void writer(ArrayList positions){
        FileWriter myfile = null;
        try {
            myfile = new FileWriter("game.txt");
            for (Object str : positions) {
                myfile.write(str + System.lineSeparator());
            }
        } catch (IOException exception) {
            exception.printStackTrace();

        } finally {
            try {
                myfile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * This method is used to save the game in the current state with the serialization.
     * @param myChess the board of my chess.
     */
    public static void save(ChessBoard myChess){
        try {
            FileOutputStream fileOut = new FileOutputStream("saveGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myChess);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in saveGame+2.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method load the serialized object of chessboard with old positions.
     * @return the new loaded board.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ChessBoard load() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(new File("saveGame.ser"));
        ObjectInputStream oi = new ObjectInputStream(fileIn);
        System.out.println("Serialized data loaded in ");

        return (ChessBoard) oi.readObject();
    }

    /**
     * This methods allows to play in real time.
     * @param myChess the board of my chess.
     * @param inputString String representing my position.
     */
    public static void play(ChessBoard myChess, String inputString){
        try {
            // create position

            String[] parts = inputString.split(" ");
            String[] initPositions = parts[0].split(""); // Initial position
            String[] lastPositions = parts[1].split(""); // Final position

            // Move Pieces
            Coord mycord = new Coord(Integer.parseInt(initPositions[0]), Integer.parseInt(initPositions[1]));

            if (myChess.getCurrentPlayer() == myChess.getPieces(mycord).getCol()) {
                Movable changingPiece = myChess.getPieces(mycord);
                changingPiece.move(new Coord(Integer.parseInt(lastPositions[0]), Integer.parseInt(lastPositions[1])));
                myChess.changePlayer();
            } else {
                System.out.println("Try " + myChess.getCurrentPlayer());
            }
        } catch (IllegalPosition e) {
            System.out.println(e);
        } catch (IllegalMove e) {
            System.out.println(e);
        }
        myChess.smartPrint();
        System.out.println("");
    }

    /**
     * This method is used to finish the game.
     */
    public static void finish(){
        System.out.println("The end of the game");
        isFinish = true;
    }
}
