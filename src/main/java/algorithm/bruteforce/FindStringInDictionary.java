package algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindStringInDictionary {


    public static List<String> StringInDictionary(Character[][] dictionary, String stringToMatch) {

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[i].length; j++) {
                findString(dictionary, stringToMatch, i, j, strings, "");
            }
        }
        return strings;
    }

    private static void findString(Character[][] dictionary, String stringToMatch, int i, int j, List<String> successfulPaths, String pathTraversed) {

        if (i > -1 && i < dictionary.length && j > -1 && j < dictionary[i].length && dictionary[i][j] == stringToMatch.charAt(0)) {

            pathTraversed = pathTraversed.concat(String.format("%s,%s;", i, j));

            if (stringToMatch.length() == 1) {
                successfulPaths.add(pathTraversed);
            } else {
                findString(dictionary, stringToMatch.substring(1, stringToMatch.length()), i - 1, j, successfulPaths, pathTraversed);
                findString(dictionary, stringToMatch.substring(1, stringToMatch.length()), i + 1, j, successfulPaths, pathTraversed);
                findString(dictionary, stringToMatch.substring(1, stringToMatch.length()), i, j - 1, successfulPaths, pathTraversed);
                findString(dictionary, stringToMatch.substring(1, stringToMatch.length()), i, j + 1, successfulPaths, pathTraversed);
            }
        }
    }




    private void findLongestPathIncreasingPathRecursive(Integer[][] matrix, int i, int j, List<Integer> longestSoFar, Stack<Integer> currentPath) {
        if (i > -1 && i < matrix.length && j > -1 && j < matrix[i].length && (currentPath.isEmpty() || matrix[i][j] > currentPath.peek())) {
            currentPath.push(matrix[i][j]);
            findLongestPathIncreasingPathRecursive(matrix, i + 1, j, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i - 1, j, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i, j + 1, longestSoFar, currentPath);
            findLongestPathIncreasingPathRecursive(matrix, i, j - 1, longestSoFar, currentPath);
        } else if (currentPath.size() > longestSoFar.size()) {
            longestSoFar = currentPath;
        }
    }
}


