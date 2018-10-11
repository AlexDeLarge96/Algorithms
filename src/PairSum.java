public class PairSum {

    public int[] getPairForSum(int[] numbers, int sumObjetive) {
        int indexLow = 0;
        int indexHigh = numbers.length - 1;
        int[] result = new int[2];
        int sum;
        do {
            if (indexHigh == indexLow) {
                break;
            }
            sum = numbers[indexLow] + numbers[indexHigh];
            if (sum > sumObjetive) {
                indexHigh--;
            } else if (sum < sumObjetive) {
                indexLow++;
            } else {
                result[0] = numbers[indexLow];
                result[1] = numbers[indexHigh];
            }
        } while (sum != sumObjetive);
        return result;
    }
}
