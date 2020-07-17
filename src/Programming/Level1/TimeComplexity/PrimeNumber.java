package Programming.Level1.TimeComplexity;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(Integer.valueOf(args[0])));
    }

    private static boolean isPrime(Integer arg) {
        // Need to check till equality since the test doesn't pass for argument 4 otherwise

        // A non prime number n can be factored as n = a*b, both a and b cant be bigger than sqrt(n), hence we only
        // need to check till sqrt(n)
        // https://stackoverflow.com/questions/5811151/why-do-we-check-up-to-the-square-root-of-a-prime-number-to-determine-if-it-is-pr

        for(int i = 2; i <= Math.sqrt(arg); i++) {
            if (arg%i == 0) {
                return false;
            }
        }
        return true;
    }
}
