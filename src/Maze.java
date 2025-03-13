public class Maze {
    private String[][] maze;
    private int r;
    private int c;

    public Maze (String[][] m) {
        maze = m;
        r = 0;
        c = 0;
    }

    public void solve() {
        System.out.println("(" + r + ", " + c + ")");
        while (r < maze.length - 1){
            if (goDown()) {
                r += 1;
            }
            else if (goUp()) {
                r -= 1;
            }
            else if (goRight()) {
                c += 1;
            }
            else if (goLeft()) {
                c -= 1;
            }
            System.out.println("(" + r + ", " + c + ")");
        }
    }

    public boolean goRight() {
        if (c + 1 < maze[0].length) {
            return maze[r][c + 1].equals(".");
        }
        return false;
    }

    public boolean goLeft() {
        if (c - 1 > maze[0].length) {
            return maze[r][c - 1].equals(".");
        }
        return false;
    }

    public boolean goDown() {
        if (r + 1 < maze.length) {
            return maze[r + 1][c].equals(".");
        }
        return false;
    }

    public boolean goUp() {
        if (r - 1 > maze.length) {
            return maze[r - 1][c].equals(".");
        }
        return false;
    }

    public void getAnswer() {

    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

}
