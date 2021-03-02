package game;

public class Coord {
    private int x;
    private int y;

    /**
     *
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
