import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class main {

    public static void main(String[] args) {
//        executeKnapsack();
//        executeMaze();
//        executeMCD();
//        executeBasicPrimes();
//        executeEratostenes();
//        executePairSum();
//        executeStringSorterer();
//        System.out.println(fibonacciTailRecursive(70, 0, 1));
//        System.out.println(fibonacciRecursive(70));
//        executeMergeSort();
        int[] arr =new int[]{256741038,623958417,467905213,714532089,938071625};
        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        long sum =0;
        for(int i=0;i< arr.length;i++){
            sum = sum + arr[i];
        }
        long min = sum;
        long max = -1;
        for (int value : arr) {
            long sumWithoutN = sum - value;
            if (sumWithoutN < min) {
                min = sumWithoutN;
            }
            if (sumWithoutN > max) {
                max = sumWithoutN;
            }
        }
        System.out.println(min + " " + max);
    }

    public static void getSum(List<Integer> array) {
        if (array.size() != 1) {

        }
    }

    public static void print(List<String> animals, Predicate<String> checker) {
        for (String animal : animals) {
            if (checker.test(animal)) {
                System.out.println(animal);
            }
        }
    }

    static String abbreviation(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length()) {
            if (j < b.length()) {
                if (a.contains(Character.toString(b.charAt(j)))) {
                    int na = a.length() - a.replace(Character.toString(b.charAt(j)), "").length();
                    int nb = b.length() - b.replace(Character.toString(b.charAt(j)), "").length();
                    if (b.charAt(j) != a.charAt(i)) {
                        if (Character.isUpperCase(a.charAt(i))) {
                            return "NO";
                        } else if (nb > na && Character.toLowerCase(b.charAt(j)) == a.charAt(i)) {
                            a = a.replaceFirst(Character.toString(a.charAt(i)), Character.toString(b.charAt(j)));
                            j++;
                        } else {
                            a = a.replaceFirst(Character.toString(a.charAt(i)), "\0");
                        }
                    } else {
                        j++;
                    }
                    i++;
                } else {
                    if (Character.toLowerCase(b.charAt(j)) == a.charAt(i)) {
                        a = a.replaceFirst(Character.toString(a.charAt(i)), Character.toString(b.charAt(j)));
                        j++;
                    } else if (Character.isUpperCase(a.charAt(i))) {
                        return "NO";
                    } else {
                        a = a.replaceFirst(Character.toString(a.charAt(i)), "\0");
                    }
                    i++;
                }
            } else {
                if (Character.isUpperCase(a.charAt(i))) {
                    return "NO";
                } else {
                    a = a.replaceFirst(Character.toString(a.charAt(i)), "\0");
                    i++;
                }
            }
        }
        if (j != b.length()) {
            return "NO";
        }
        return "YES";
    }

    static long numberOfAinInfiniteCad(String cad, long n) {
        return countAInCad(cad) * (n / cad.length()) + countAInCad(cad.substring(0, (int) (n % cad.length())));
    }

    static int countAInCad(String cad) {
        return cad.length() - cad.replace("a", "").length();
    }

    static long fibonacciTailRecursive(int n, int a, int b) {
        if (n <= 0) return a;
        if (n == 1) return b;
        return fibonacciTailRecursive(n - 1, b, a + b);
    }

    static long fibonacciRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static boolean isEven(int num) {
        return (num & 1) == 1 ? false : true;
    }

    static boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }

    public static int sum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i], Math.max(arr[i - 1], arr[i] + arr[i - 2]));
        return arr[arr.length - 1];
    }

    public static int countNumberOfOnesInBinary(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
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
        int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Maze m = new Maze(maze, new int[]{3, 0}, new int[]{3, 3});
        int[][] solve = m.SolveMaze();
        System.out.println("\nMaze Problem:\nMaze Solution:");
        printMaze(maze);
        System.out.println("\n");
        printMaze(solve);
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

    private static void printMaze(int[][] solve) {

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
        System.out.println("Primes Minor than 1000000000: " + eratostenes.listOfPrimesMinorThanN(100000000));
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

    private static void executePairSum() {
        int[] numbers = new int[]{1, 7, 8};
        PairSum pairSum = new PairSum();
        int[] result = pairSum.getPairForSum(numbers, 15);
        System.out.println(result[0] + " " + result[1]);
    }

    private static void executeStringSorterer() {
        StringSorterer sorterer = new StringSorterer();
        sorterer.sortString("abacdc");
    }

    private static void executeMergeSort() {
        MergeSort mergeSort = new MergeSort();
        List<Integer> result = mergeSort.sort(Arrays.asList(-4, 2, 3, 5, 0, 1));
        System.out.println(result);
    }
}
