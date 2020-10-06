import java.math.BigInteger;

public class PermutationAndCombination {
    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static void main(String args[]) {
        int n = 7, r = 3;
        BigInteger comb, per;
        per = factorial(n).divide(factorial(n - r));
        System.out.println("Permutation: " + per);
        comb = factorial(n).divide((factorial(r).multiply(factorial(n - r))));
        System.out.println("Combination: " + comb);
    }
}