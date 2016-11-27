package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindLongestPathInMatrix {

    public static List<Integer> longestPathIncreasingInMatrix(final Integer[][] matrix) {
        List<Integer> longestIncreasingPath = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                List<Integer> longestFromCurrentVertex = new ArrayList<>();
                Stack<Integer> currentPath = new Stack<>();
                findLongestPathIncreasingPathRecursive(matrix, i, j, longestFromCurrentVertex, currentPath);
                if (longestIncreasingPath.size() < longestFromCurrentVertex.size()) {
                    longestIncreasingPath = longestFromCurrentVertex;
                }
            }
        }
        return longestIncreasingPath;
    }


    private static void findLongestPathIncreasingPathRecursive(Integer[][] matrix, int i, int j, List<Integer> longestSoFar, Stack<Integer> currentPath) {
        if (i > -1 && i < matrix.length && j > -1 && j < matrix[i].length && (currentPath.isEmpty() || matrix[i][j] >= currentPath.peek())) {
            currentPath.push(matrix[i][j]);
            findLongestPathIncreasingPathRecursive(matrix, i + 1, j, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i - 1, j, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i, j + 1, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i, j - 1, longestSoFar, currentPath);
        } else if (currentPath.size() > longestSoFar.size()) {
            longestSoFar.clear();
            longestSoFar.addAll(currentPath);
        }
    }

}



