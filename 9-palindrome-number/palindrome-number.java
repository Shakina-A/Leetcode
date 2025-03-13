class Solution {
    public boolean isPalindrome(int x) {
        int revnum=0;
        int num=x;
        if(x<0){
            return false;
        }
        while(x>0){
            int ld=x%10;
            revnum=revnum*10+ld;
            x=x/10;
        }
        if(revnum==num)return true;
        else return false;
    }
}