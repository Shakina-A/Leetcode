class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxIndex = 0;
        for(int i=0; i<nums.length; i++){
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(maxIndex >= nums.length-1){
                return true;
            }
            if(maxIndex <= i){
                return false;
            }
        }
        if (maxIndex == nums.length-1) return true;
        else return false;
    }
}