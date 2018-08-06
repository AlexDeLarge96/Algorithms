import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Type 1 to execute the Knapsack's problem or another key for execute the maze's problem:");
        String opc = scan.next();
        System.out.print("\n");
        if (opc.equals("1")) {
            int[] value = new int[]{1, 2, 3};
            int[] weight = new int[]{7, 3, 5};
            int capacity = 8;
            int profit = 0;
            Knapsack k = new Knapsack(capacity, weight, value);
            int[] solve = k.maxProfit();
            System.out.print("List of included products: ");
            for (int i = 0; i < solve.length; i++) {
                if (solve[i] != 0) {
                    System.out.print(i + 1 + " ");
                    profit += value[i];
                }
            }
            System.out.println("\nMax profit: " + profit);
        } else {
            int[][] maze = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 1, 0}, {0, 0, 1, 1}};
            Maze m = new Maze(maze, new int[]{3, 0}, new int[]{3, 3});
            int[][] solve = m.SolveMaze();
            System.out.println("Maze Solution:");
            for (int i = 0; i < solve.length; i++) {
                for (int j = 0; j < solve.length; j++) {
                    System.out.print(solve[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
