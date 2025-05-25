class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number at its correct index if possible
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 && 
                nums[i] <= n && 
                nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Now, find the first index i such that nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
