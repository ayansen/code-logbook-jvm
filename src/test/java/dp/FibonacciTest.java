package dp;

import org.junit.Test;

/**
 * Created by aysen on 10/2/16.
 */
public class FibonacciTest {

    @Test
    public void testFibonacciNumbers() {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        System.out.println(fibonacciSeries.sumFibonacci(10));
    }
}
