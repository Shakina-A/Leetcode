import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> next greater
        Stack<Integer> stack = new Stack<>();

        // Process nums2 in reverse to find next greater for each element
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            // Maintain decreasing stack
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is empty, no greater element
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            map.put(current, nextGreater);

            stack.push(current);
        }

        // Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
