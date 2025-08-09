class Solution {
    public int missingNumber(int[] nums) {
        int XOR1=0,XOR2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
           XOR1^=nums[i];
        }
        for(int i=0;i<=n;i++)
        {
            XOR2^=i;
        }
        int ans=XOR1^XOR2;
        return ans;
        
    }
}