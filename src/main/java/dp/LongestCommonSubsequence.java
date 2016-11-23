package dp;

/**
 * Created by aysen on 10/1/16.
 */
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
            return recursiveLCS(firstString, secondString, positionOfFirstString - 1, positionOfSecondString - 1, memo) + 1;
        } else {
            return Math.max(recursiveLCS(firstString, secondString, positionOfFirstString, positionOfSecondString - 1, memo), recursiveLCS(firstString, secondString, positionOfFirstString - 1, positionOfSecondString, memo));
        }

    }


    public int longestCommonSubsequence(String firstString, String secondString) {

        Integer[][] memo = new Integer[firstString.length()][secondString.length()];

        return recursiveLCS(firstString.toCharArray(), secondString.toCharArray(), firstString.length() - 1, secondString.length() - 1,memo);
       /*
        */
    }

    private int lcsIterative(char[] firstString, char[] secondString) {

        //min(f(x-1,y),f(x,y-1)) + 1 if(firstString[i] == secondString[j])

        Integer[][] memo = new Integer[firstString.length][secondString.length];
        for (int i = 0; i < firstString.length; i++) {

            for (int j = 0; j < secondString.length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (firstString[i] == secondString[j]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[firstString.length - 1][secondString.length - 1];

    }


}
