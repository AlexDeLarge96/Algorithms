
public class main {

    public static void main(String[] args) {
        executeKnapsack();
        executeMaze();
    }

    private static void executeKnapsack() {
        int[] value = new int[]{1, 2, 3};
        int[] weight = new int[]{7, 3, 5};
        int capacity = 8;
        Knapsack k = new Knapsack(capacity, weight, value);
        int profit = k.calculateMaxProfit();
        int[] items = k.obtainListItems(profit);
        printKnapsackSolve(profit, items);
    }

    private static void executeMaze() {
        int[][] maze = {{0,1,0}, {0,1,0}, {0,0,0}};
        Maze m = new Maze(maze, new int[]{3, 0}, new int[]{3, 3});
        int[][] solve = m.SolveMaze();
        printMazeSolve(solve);
    }

    private static void printKnapsackSolve(int profit, int[] items) {
        System.out.print("Knapsack Problem:\nList of included products: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println("\nMax profit: " + profit);
    }

    private static void printMazeSolve(int[][] solve) {
        System.out.println("\nMaze Problem:\nMaze Solution:");
        for (int i = 0; i < solve.length; i++) {
            for (int j = 0; j < solve.length; j++) {
                System.out.print(solve[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
