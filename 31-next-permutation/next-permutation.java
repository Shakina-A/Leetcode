public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the break point:
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no break point found, reverse the entire array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element to swap with nums[ind]
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 3: Reverse the subarray from ind + 1 to end
        reverse(nums, ind + 1, n - 1);
    }

    // Helper method to reverse array in-place
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // Helper method to swap two elements in array
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
