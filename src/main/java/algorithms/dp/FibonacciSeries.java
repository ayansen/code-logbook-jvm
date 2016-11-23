package algorithms.dp;

/**
 * Created by aysen on 10/1/16.
 */
public class FibonacciSeries {

    public int sumFibonacci(int n) {
        Integer[] memo = new Integer[n + 1];
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == 0) {
            memo[n] = 0;
        } else if (n == 1 || n == 2) {
            memo[n] = 1;
        } else {
            memo[n] = sumFibonacci(n - 1) + sumFibonacci(n - 2);
        }
        return memo[n];
    }
}
