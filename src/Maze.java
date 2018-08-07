class Maze {

    private int[][] maze;
    private int[] posInitial;
    private int[] posFinal;
    private int[][] solve;

    Maze(int[][] maze, int[] posInitial, int[] posFinal) {
        this.maze = maze;
        this.posInitial = posInitial;
        this.posFinal = posFinal;
        this.solve = new int[maze.length][maze.length];
    }

    int[][] SolveMaze() {
        move(posInitial[0], posInitial[1]);
        return solve;
    }

    private void move(int x, int y) {

        if (isValidPath(x, y)) { solve[x][y] = 1; }
        moveRight(x, y);
        moveLeft(x, y);
        moveUp(x, y);
        moveDown(x, y);
    }

    private boolean isValidPath(int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y]!=1);
    }

    private void moveRight(int x, int y) {
        if (isValidPath(x, y + 1) && solve[x][y + 1] != 1 && notIsExit(x, y)) {
            move(x, y + 1);
        }
    }

    private void moveLeft(int x, int y) {
        if (isValidPath(x, y - 1) && solve[x][y - 1] != 1 && notIsExit(x, y)) {
            move(x, y - 1);
        }
    }

    private void moveUp(int x, int y) {
        if (isValidPath(x + 1, y) && solve[x + 1][y] != 1 && notIsExit(x, y)) {
            move(x + 1, y);
        }
    }

    private void moveDown(int x, int y) {
        if (isValidPath(x - 1, y + 1) && solve[x - 1][y] != 1 && notIsExit(x, y)) {
            move(x - 1, y);
        }
    }

    private boolean notIsExit(int x, int y) {
        return !(x == posFinal[0] && y == posFinal[1]);
    }
}
