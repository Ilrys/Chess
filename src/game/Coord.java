package game;

import java.io.Serializable;

public class Coord implements Serializable {
    private int x;
    private int y;

    /**
     * This method calibrates the x and y positions
     * @param x represent the x value coordinate in matrix
     * @param y represent the y value coordinate in matrix
     */
    public Coord(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
