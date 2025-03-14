public class Maze {
    private String[][] maze;
    private final String CHECKED = "C";
    private final String PATH = "P";
    private int r;
    private int c;

    public Maze (String[][] m) {
        maze = m;
        r = 0;
        c = 0;
    }

    public boolean findPath() {
        boolean done = false;
        if (validPosition(r, c)) {
            checkPosition(r, c);
            if (solved()) {
                done = true;
            } else {
                if (!done) {
                    if (goRight()) {
                        c += 1;
                        done = true;
                        System.out.print("(" + r + ", " + c + ") ---->");
                    }
                    done = findPath();
                }
                if (!done) {
                    if (goDown()) {
                        r += 1;
                        done = true;
                        System.out.print("(" + r + ", " + c + ") ---->");
                    }
                }
                if (!done) {
                    if (goUp()) {
                        r -= 1;
                        done = true;
                        System.out.print("(" + r + ", " + c + ") ---->");
                    }
                }
                if (!done) {
                    if (goLeft()) {
                        c -= 1;
                        done = true;
                        System.out.print("(" + r + ", " + c + ") ---->");
                    }
                }
            }
        }
        return done;
    }

    public void getAnswer() {
        for (int r = 0; r < maze.length - 1; r++) {
            for (int c = 0; c < maze[0].length - 1; c++) {
                findPath();
            }
        }
        for (int r = 0; r < maze.length - 1; r++) {
            for (int c = 0; c < maze[0].length - 1; c++) {
                if (maze[r][c].equals(CHECKED)) {
                    System.out.print("(" + r + ", " + c + ") ---->");
                }
            }
        }
    }


    public boolean solved() {
        return r == maze.length - 1 && c == maze[0].length - 1;
    }

    public void checkPosition(int row, int col) {
        maze[row][col] = CHECKED;
    }

    public void placePath(int row, int col) {
        maze[row][col] = PATH;
    }

    public boolean validPosition(int row, int col) {
        if (row >= 0 && row < maze.length - 1 && col >= 0 && col < maze[0].length - 1) {
            if (maze[row][col].equals(".")) {
                return true;
            }
        }
        return false;
    }

    public boolean goRight() {
        return maze[r][c + 1].equals(".");
    }

    public boolean goLeft() {
        return maze[r][c - 1].equals(".");
    }

    public boolean goDown() {
        return maze[r + 1][c].equals(".");
    }

    public boolean goUp() {
       return maze[r - 1][c].equals(".");
    }

    public String[][] getMaze() {
        return maze;
    }

}
