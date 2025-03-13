class Solution {
    public int maxArea(int[] a) {
        
 int left = 0;
        int right = a.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(a[left], a[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, height * width);

            // Move the pointer for the shorter line
            if (a[left] < a[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}