import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Pair each score with its index
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        // Sort scores in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = scoreWithIndex[i][1];
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
