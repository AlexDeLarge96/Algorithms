import java.util.ArrayList;
import java.util.List;

public class BasicPrimes {

    public List<Integer> getPrimesMinorThanN(int n){
        List<Integer> primes= new ArrayList<>();
        primes.add(2);
        if(n<=2){return new ArrayList<>();}
        else {
            for (int i = 3; i < n; i += 2) {
                if (isPrime(i)) primes.add(i);
            }
        }
        return primes;
    }
    private boolean isPrime(int n) {
        int i = 2;
        while (n % i != 0) i++;
        return i == n;
    }
}
