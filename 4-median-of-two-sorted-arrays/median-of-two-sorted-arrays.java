import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        add(nums1, 0, nums1.length, arr, 0);  // Corrected this line
        add(nums2, 0, nums2.length, arr, nums1.length);  // Corrected this line
        Arrays.sort(arr);  // Sort the merged array
        int n = arr.length;
        double ans = 0.0;
        if (n % 2 == 0) {
            // For even length, take average of two middle elements
            ans = (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            // For odd length, take the middle element
            ans = arr[n / 2];
        }
        return ans;
    }
    public void add(int[] nums, int startIdx, int len, int[] arr, int arrIdx) {
        for (int i = 0; i < len; i++) {
            arr[arrIdx + i] = nums[i];
        }
    }
}
