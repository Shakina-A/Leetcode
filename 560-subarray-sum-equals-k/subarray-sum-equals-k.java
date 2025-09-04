import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initialize the map with sum 0 having one count
        prefixSumCount.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Check if (sum - k) has been seen before
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update prefix sum frequency in the map
            if (prefixSumCount.containsKey(sum)) {
                int currentFreq = prefixSumCount.get(sum);
                prefixSumCount.put(sum, currentFreq + 1);
            } else {
                prefixSumCount.put(sum, 1);
            }
        }

        return count;
    }
}
