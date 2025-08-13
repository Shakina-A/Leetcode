class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos=new int[nums.length/2];
        int[]negative=new int[nums.length/2];
        int j=0;int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                negative[j]=nums[i];
                j++;
            }
            else{
                pos[k]=nums[i];
                k++;
            }
        }
        j=0;k=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=pos[k];
                k++;
            }
            else{
                nums[i]=negative[j];
                j++;
            }
        }
        return nums;
    }
}