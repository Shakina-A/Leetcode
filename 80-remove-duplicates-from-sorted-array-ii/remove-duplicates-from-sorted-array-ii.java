class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int writeIndex = 2;  // Start from the third element

        for (int i = 2; i < nums.length; i++) {
            // Compare current number with the number two places before
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }
}
