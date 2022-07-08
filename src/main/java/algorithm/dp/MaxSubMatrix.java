package algorithm.dp;

import java.util.Arrays;

public class MaxSubMatrix {

    /**
     * Given a matrix m*n with numbers find the submatrix with the highest sum
     *
     * @param matrix input matrix
     * @return max
     */
    public static int findSubMatrixWithHighestSum(int[][] matrix) {
        int[][] subMatrices = createSubMatricesWithSum(matrix);
        return Arrays.stream(subMatrices)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();
    }

    private static int[][] createSubMatricesWithSum(int[][] matrix) {
        int[][] subMatrices = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int sumOfColoumn = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sumOfColoumn = sumOfColoumn + matrix[i][j];
                if (i == 0) {
                    subMatrices[i][j] = sumOfColoumn;
                } else {
                    subMatrices[i][j] = subMatrices[i - 1][j] + sumOfColoumn;
                }
            }
        }
        return subMatrices;
    }
}
