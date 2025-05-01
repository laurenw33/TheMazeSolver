import java.util.Arrays;

public class Maze {
    private String[][] maze;
    private final String CHECKED = "C";
    int row;
    int col;

    public Maze(String[][] m) {
        maze = m;
        row = 0;
        col = 0;
    }

    public void findPath() {
        maze[row][col] = CHECKED; // this will be our identifier for our path

        boolean complete = false;
        System.out.print("(" + row + ", " + col + ") --> "); // the first coordinate won't be printed

        while (!complete) {
            if (row == maze.length - 1 && col == maze[0].length - 1) { // if it hits the last row and col, it'll stop
                complete = true;
            }
            else if (validPosition(row + 1, col)) { // down
                row++;
                maze[row][col] = CHECKED; // marks checked so we know the path that we took
            }
            else if (validPosition(row, col + 1)) { // right
                col++;
                maze[row][col] = CHECKED;
            }
            else if (validPosition(row - 1, col)) { // up
                row--;
                maze[row][col] = CHECKED;
            } else if (validPosition(row, col - 1)) { // left
                col--;
                maze[row][col] = CHECKED;
            }
            else { // if cant be checked put a # to remove dead end
                maze[row][col] = "#";

                if (isChecked(row + 1, col)) { // if already checked it will move on to a different spot
                    row++; // down
                }
                else if (isChecked(row, col + 1)) {
                    col++; // right
                }
                else if (isChecked(row - 1, col)) {
                    row--; // up
                }
                else if (isChecked(row, col - 1)) {
                    col--; // left
                }
                else { // ends loop
                    complete = true;
                }
            }
            if (maze[row][col].equals(CHECKED)) {
                System.out.print("(" + row + ", " + col + ") --> "); // prints out each of the coordinates after each movement (each loop is one movement)
            }
        }
    }

    public boolean isChecked(int row, int col) {
        return maze[row][col].equals(CHECKED);
    }

    public void solve() {
        findPath();
    }

    public boolean validPosition(int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col].equals(".");
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
