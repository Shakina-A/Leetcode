public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                totalSum += Math.abs(val);
                if (val < 0) negativeCount++;
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        // If odd number of negatives, subtract twice the smallest abs value
        if (negativeCount % 2 == 1) {
            totalSum -= 2L * minAbs;
        }

        return totalSum;
    }
}
