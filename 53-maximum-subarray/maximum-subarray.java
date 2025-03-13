class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int currentmax=nums[0];
        //int sum=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            currentmax=Math.max(nums[i],currentmax+nums[i]);
            max=Math.max(max,currentmax);
        }
        return max;
    }
}