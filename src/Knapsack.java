public class Knapsack {

    private int capacity;
    private int[] weight;
    private int[] value;

    public Knapsack(int capacity, int[] weight, int[] value) {
        this.capacity = capacity;
        this.weight = weight;
        this.value = value;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int[] maxProfit() {
        int n = value.length + 1;
        int i;
        int w = 0;
        int[][] K = new int[n][capacity + 1];
        for (i = 0; i < n; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else {
                    if (weight[i - 1] > w) {
                        K[i][w] = K[i - 1][w];
                    } else {
                        K[i][w] = max(K[i - 1][w], K[i - 1][w - weight[i - 1]] + value[i - 1]);
                    }
                }
            }
        }
        int profit = K[i - 1][w - 1];
        int[] items = new int[value.length];
        for (i = value.length - 1; i >= 0; i--) {
            if (value[i] <= profit) {
                items[i] = 1;
                profit -= value[i];
            } else {
                items[i] = 0;
            }
        }
        return items;
    }
}
