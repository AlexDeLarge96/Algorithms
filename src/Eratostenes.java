import java.util.ArrayList;
import java.util.List;

public class Eratostenes {

    public List<Long> listOfPrimesMinorThanN(int n) {
        List<Long> primes = new ArrayList<>();
        if (n > 2) {
            boolean[] isComposite = new boolean[(int) (n / 2.0 + 0.5)];
            for (int i = 1; i < isComposite.length; i++) {
                if (!isComposite[i]) {
                    long num = 2L * i + 1L;
                    long multiple = num;
                    if(num!=n) primes.add(num);
                    while (num * multiple <= 2 * isComposite.length - 1) {
                        isComposite[(int)(num * multiple - 1) / 2] = true;
                        multiple += 2;
                    }
                }
            }
            primes.add(0, 2L);
        }
        return primes;
    }
}
