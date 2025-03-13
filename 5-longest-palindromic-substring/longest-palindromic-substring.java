class Solution {
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    if(j-i+1>longest.length())
                    {
                        longest = s.substring(i,j+1);
                    }
                }
            }
        }
        return longest;
    }
}