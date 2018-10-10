public class Euclides {

    public int mcd(int a, int b) {
        if (a == b) {
            return 1;
        } else {
            if (b > a) {
                int acu = a;
                a = b;
                b = acu;
            }
            if (b == 0) {
                return a;
            } else {
                return mcd(b, a % b);
            }
        }
    }
}
