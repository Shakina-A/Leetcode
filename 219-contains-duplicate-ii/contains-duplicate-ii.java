import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            }

            seen.add(nums[i]);

            // Keep the set size at most k
            if (seen.size() > k) {
                seen.remove(nums[i - k]);
            }
        }

        return false;
    }
}
