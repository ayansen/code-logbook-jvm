package datastructure;

import datastructure.stack.problems.StackProblems;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by aysen on 10/13/16.
 */
public class StackTest {

    @Test
    public void testStackSpans() {
        List<Integer> stockPrices = new ArrayList<>(10);
        stockPrices.add(123);
        stockPrices.add(15);
        stockPrices.add(3);
        stockPrices.add(24);
        stockPrices.add(21);
        stockPrices.add(49);


        StackProblems.getStockSpanUsingStack(stockPrices).entrySet().stream().forEach(System.out::println);

    }

    @Test
    public void testReverseStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(15);
        stack.push(3);
        stack.push(24);
        stack.push(21);
        stack.push(49);

        stack.stream().forEach(System.out::println);
        StackProblems.reverseStack(stack);
        stack.stream().forEach(System.out::println);

    }

    @Test
    public void testSortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(15);
        stack.push(3);
        stack.push(24);
        stack.push(21);
        stack.push(49);

        stack.stream().forEach(System.out::println);
        StackProblems.sortStack(stack);
        stack.stream().forEach(System.out::println);

    }

    @Test
    public void testNGE() {
        List<Integer> numbers = new ArrayList<>(10);
        numbers.add(123);
        numbers.add(15);
        numbers.add(3);
        numbers.add(24);
        numbers.add(21);
        numbers.add(49);


        StackProblems.findNextGreatestNumber(numbers).entrySet().stream().forEach(System.out::println);

    }

}
