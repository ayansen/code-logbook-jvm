package algorithm.mathematicaloptimizations.problems;

/**
 * Created by aysen on 10/19/16.
 */

import java.util.*;

public class StackProblems {

    /**
     * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
     * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
     * k = 3
     * Output :
     * 3 3 4 5 5 5 6
     **/
    public static List<Integer> getMaximumNumberInWindow(List<Integer> numbers, int k) {

        int i = 0;
        List<Integer> maxInWindows = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (; i < k; i++) {
            int number = numbers.get(i);
            while (!queue.isEmpty() && number > numbers.get(queue.peek())) {
                queue.pop();
            }
            queue.push(i);
        }

        for (; i < numbers.size(); i++) {
            maxInWindows.add(numbers.get(queue.getFirst()));
            int number = numbers.get(i);
            while (!queue.isEmpty() && number > numbers.get(queue.peek())) {
                queue.pop();
            }
            queue.push(i);
            if (queue.getFirst() < (i - k)) {
                queue.removeFirst();
            }
        }

        return numbers;
    }

    /**
     * Given an array find the next greater integer for each element.
     * arr[] = {4, 5, 2, 25}     *
     * Output :
     * {5,25,25,-1}
     **/

    public static Map<Integer, Integer> findNextGreatestNumber(List<Integer> numbers) {

        Stack<Integer> importantIndices = new Stack<>();
        Map<Integer, Integer> nextGreatestNumber = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {

            while (!importantIndices.empty() && numbers.get(i) > numbers.get(importantIndices.peek())) {
                nextGreatestNumber.put(numbers.get(importantIndices.pop()), numbers.get(i));
            }
            importantIndices.push(i);
        }
        while (!importantIndices.empty()) {
            nextGreatestNumber.put(numbers.get(importantIndices.pop()), -1);

        }
        return nextGreatestNumber;
    }

    /**
     * The span Si of the stock’s price on a given day i is
     * defined as the maximum number of consecutive days just before the given day,
     * for which the price of the stock on the current day is less than or equal to its price on the given day.
     * <p>
     * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
     * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
     */
    public static Map<Integer, Integer> getStockSpanUsingStack(List<Integer> dailyStockPrices) {

        Map<Integer, Integer> stockSpans = new HashMap<>();
        Stack<Integer> priceStack = new Stack<>();
        dailyStockPrices.forEach(priceStack::push);
        List<Integer> reversedStockPrices = new ArrayList<>();
        while (!priceStack.isEmpty()) {
            reversedStockPrices.add(priceStack.pop());
        }

        for (int i = 0; i < reversedStockPrices.size(); i++) {
            int price = reversedStockPrices.get(i);
            while (!priceStack.isEmpty() && price > reversedStockPrices.get(priceStack.peek())) {
                priceStack.pop();
            }
            if (!priceStack.isEmpty()) {
                stockSpans.put(price, i - priceStack.peek());
            } else {
                stockSpans.put(price, i + 1);
            }
            priceStack.push(i);
        }
        return stockSpans;
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int largestElement = popLargestElement(stack);
        sortStack(stack);
        stack.push(largestElement);
    }


    private static Integer popLargestElement(Stack<Integer> stack) {

        int head = stack.pop();
        if (stack.empty()) {
            return head;
        } else {
            int currentMax = popLargestElement(stack);
            if (currentMax >= head) {
                stack.push(head);
                return currentMax;
            } else {
                stack.push(currentMax);
                return head;
            }
        }
    }


    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }


    private static Integer popBottom(Stack<Integer> stack) {
        int head = stack.pop();

        if (!stack.empty()) {
            int bottom = popBottom(stack);
            stack.push(head);
            return bottom;
        }
        return head;
    }

}
