package algorithms.dp;

public class LongestCommonSubsequence {

    // 0 | 0 | 0 | 0 |0 |0 | 0| 0
    // 0 | 0 | 0 | 1 |1 |1 | 1| 1
    // 0 | 0 | 0 | 0 |0 |0 | 0| 0
    // 0 | 0 | 0 | 0 |0 |0 | 0| 0
    // 0 | 0 | 0 | 0 |0 |0 | 0| 0
    // 0 | 0 | 0 | 0 |0 |0 | 0| 0


    // Axbrcsaor
    // bc3sds


    public int recursiveLCS(char[] firstString, char[] secondString, int positionOfFirstString, int positionOfSecondString, Integer[][] memo) {

        if (memo[positionOfFirstString][positionOfSecondString] != null) {
            return memo[positionOfFirstString][positionOfSecondString];
        }
        if (positionOfFirstString == 0 || positionOfSecondString == 0) {
            return 0;
        }
        if (firstString[positionOfFirstString] == secondString[positionOfSecondString]) {
            memo[positionOfFirstString][positionOfSecondString] = recursiveLCS(firstString, secondString, positionOfFirstString - 1, positionOfSecondString - 1, memo) + 1;
        } else {
            memo[positionOfFirstString][positionOfSecondString] = Math.max(recursiveLCS(firstString, secondString, positionOfFirstString, positionOfSecondString - 1, memo), recursiveLCS(firstString, secondString, positionOfFirstString - 1, positionOfSecondString, memo));
        }
        return memo[positionOfFirstString][positionOfSecondString];

    }


    public int longestCommonSubsequence(String firstString, String secondString) {

        Integer[][] memo = new Integer[firstString.length()][secondString.length()];

        return recursiveLCS(firstString.toCharArray(), secondString.toCharArray(), firstString.length() - 1, secondString.length() - 1, memo);
       /*
        */
    }


}
