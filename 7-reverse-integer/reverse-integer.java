class Solution {
    public int reverse(int num) {
        int revnum = 0;
        
        // Store the sign to reapply it later
        int n = num;
        
        // Handle negative number case
        if (num < 0) {
            num = -num;
        }
        
        // Reverse the digits
        while (num > 0) {
            int ld = num % 10;  // Get the last digit
            // Check for overflow before multiplying by 10
            if (revnum > Integer.MAX_VALUE / 10 || (revnum == Integer.MAX_VALUE / 10 && ld > 7)) {
                return 0;  // Overflow condition for positive overflow
            }
            revnum = revnum * 10 + ld;  // Append the last digit to revnum
            num = num / 10;  // Remove the last digit from num
        }
        
        // If the number was negative, return negative reversed number
        if (n < 0) {
            revnum = -revnum;
        }
        
        // Check for underflow condition (overflow for negative numbers)
        if (revnum < Integer.MIN_VALUE) {
            return 0;
        }
        
        return revnum;
    }
}
