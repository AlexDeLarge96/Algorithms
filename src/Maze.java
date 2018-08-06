public class Maze {

    private int[][] maze;
    private int[] posInitial;
    private int[] posFinal;

    public Maze(int[][] maze, int[] posInitial, int[] posFinal) {
        this.maze = maze;
        this.posInitial = posInitial;
        this.posFinal = posFinal;
    }

    private boolean isValidPath(int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze.length) {
            if (maze[x][y] != 1) {
                return true;
            }
        }
        return false;
    }

    public int[][] SolveMaze() {
        int[][] solve = new int[maze.length][maze.length];
        return move(posInitial[0], posInitial[1], solve);
    }

    private int[][] move(int x, int y, int[][] solve) {
        int escape=0;
        if (isValidPath(x, y)) {
            if(x==posFinal[0] && y==posFinal[1]){escape=1;}
            solve[x][y] = 1;
        }
        if (isValidPath(x, y + 1) && solve[x][y + 1] != 1 && escape==0) {
            move(x, y + 1, solve);
        }
        if (isValidPath(x, y - 1) && solve[x][y - 1] != 1 && escape==0) {
            move(x, y - 1, solve);
        }
        if (isValidPath(x + 1, y) && solve[x + 1][y] != 1 && escape==0) {
            move(x + 1, y, solve);
        }
        if (isValidPath(x - 1, y + 1) && solve[x - 1][y] != 1 && escape==0) {
            move(x - 1, y, solve);
        }
        return solve;
    }
}
