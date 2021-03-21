package fx;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public abstract class Pictures {

    public Pictures(){
    }

    /**
     *
     * @return
     */
    public static Image[][] loadAssets()
    {
            Image imagePieces = new Image("fx/ChessPieces.png",600,200,false, false); // size piece
            // Cut the Piece
            int h = (int)imagePieces.getHeight();
            int w = (int)imagePieces.getWidth();
            int pieceHeight = h/2;
            int pieceWidth = w/6;

            Image[][] pieces = new Image[2][6];
            PixelReader reader = imagePieces.getPixelReader();
            for (int x=0;x<6;x++)
            {
                pieces[0][x] = new WritableImage(reader, x * pieceWidth, 0, pieceWidth, pieceHeight);
                pieces[1][x] = new WritableImage(reader, (5-x) * pieceWidth, pieceHeight, pieceWidth, pieceHeight);
            }
            return pieces;
    }
}
