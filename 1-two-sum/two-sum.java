class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int c=target-nums[i];
            if(map.containsKey(c)){
                
                return new int[]{map.get(c),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
            throw new IllegalArgumentException("No solution");
        }
        
        
    
}