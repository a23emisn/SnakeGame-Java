package Snake;

/**
 * This Class Represents an individual cell in a grid.
 */
public class Cell {
    private int x;
    private int y;
    private int contains;

    public Cell(int x, int y) {
        contains = 0;
        this.x = x;
        this.y = y;
    }

    public int getContains() {
        return contains;
    }

    public void setContains(int type) {
        contains = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
