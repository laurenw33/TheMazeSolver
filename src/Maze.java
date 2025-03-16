public class Maze {
    private String[][] maze;
    private final String CHECKED = "C";
    private final String PATH = "P";

    public Maze(String[][] m) {
        maze = m;
    }

    public boolean findPath(int row, int col) {
        if (!validPosition(row, col)) {
            return false;
        }

        System.out.print("(" + row + ", " + col + ") --> ");

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            maze[row][col] = PATH;
            System.out.println("(" + row + ", " + col + ") [GOAL]");
            return true;
        }

        maze[row][col] = CHECKED;

        if (findPath(row, col + 1) ||
                findPath(row + 1, col) ||
                findPath(row - 1, col) ||
                findPath(row, col - 1)) {

            maze[row][col] = PATH;
            return true;
        }

        return false;
    }

    public void solve() {
        System.out.println("Path taken:");
        if (findPath(0, 0)) {
            System.out.println("Solution found!");
            printMaze();
        } else {
            System.out.println("No path found.");
        }
    }

    public boolean validPosition(int row, int col) {
        return row >= 0 && row < maze.length &&
                col >= 0 && col < maze[0].length &&
                maze[row][col].equals(".");
    }

    public void printMaze() {
        for (String[] row : maze) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public String[][] getMaze() {
        return maze;
    }
}
