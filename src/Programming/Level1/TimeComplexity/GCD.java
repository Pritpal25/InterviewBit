package Programming.Level1.TimeComplexity;

public class GCD {
    public static int gcd(int a, int b) {
        if (a < 0) {
            a = Math.abs(a);
        }

        if (b < 0) {
            b = Math.abs(b);
        }

        if (a < b) {
            int x = a;
            a = b;
            b = x;
        }

        // Remainder become the next divisor and divisor keeps becoming the next dividend
        // until the remainder is 0.
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
    }
}
