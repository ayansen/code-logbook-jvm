package algorithms.dp;


public class FibonacciSeries {

    public int sumFibonacci(int n) {
        Integer[] memo = new Integer[n + 1];
        return sumFibonacciRecursive(n, memo);
    }

    private int sumFibonacciRecursive(int n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == 0) {
            memo[n] = 0;
        } else if (n == 1 || n == 2) {
            memo[n] = 1;
        } else {
            memo[n] = sumFibonacciRecursive(n - 1, memo) + sumFibonacciRecursive(n - 2, memo);
        }
        return memo[n];
    }
}
