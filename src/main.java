
public class main {

    public static void main(String[] args) {
//        executeKnapsack();
//        executeMaze();
//        executeMCD();
//        executeBasicPrimes();
//        executeEratostenes();
        executePairSum();
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
        int[][] maze = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
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

    private static void executeMCD() {
        System.out.println("\nEuclides Algorithm:\n");
        Euclides euclides = new Euclides();
        System.out.println("MCD(16,18)= " + euclides.mcd(16, 18));
        System.out.println("MCD(124,146)= " + euclides.mcd(124, 146));
        System.out.println("MCD(55,89)= " + euclides.mcd(55, 89));
        System.out.println("MCD(15,5)= " + euclides.mcd(15, 5));
        System.out.println("MCD(120,0)= " + euclides.mcd(120, 0));
        System.out.println("MCD(0,89)= " + euclides.mcd(0, 89));
    }

    private static void executeEratostenes() {
        System.out.println("\nEratostenes Algorithm:\n");
        Eratostenes eratostenes = new Eratostenes();
        long initialTime = System.currentTimeMillis();
        System.out.println("Primes Minor than 100000: " + eratostenes.listOfPrimesMinorThanN(100000000));
        long actualTime = System.currentTimeMillis() - initialTime;
        System.out.println("Elapsed Time: " + actualTime + " milliseconds");

    }

    private static void executeBasicPrimes() {
        System.out.println("\nBasic Primes Algorithm:\n");
        BasicPrimes basicPrimes = new BasicPrimes();
        long initialTime = System.currentTimeMillis();
        System.out.println("Primes Minor than 100000: " + basicPrimes.getPrimesMinorThanN(100000));
        long actualTime = System.currentTimeMillis() - initialTime;
        System.out.println("Elapsed Time: " + actualTime + " milliseconds");
    }

    private static void executePairSum(){
        int[] numbers=new int[]{1,7,8};
        PairSum pairSum=new PairSum();
        int[] result=pairSum.getPairForSum(numbers,15);
        System.out.println(result[0]+" "+result[1]);
    }
}
