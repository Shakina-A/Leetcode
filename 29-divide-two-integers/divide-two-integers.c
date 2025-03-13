int divide(int dividend, int divisor) {
    if (divisor == 0 || (dividend == INT_MIN && divisor == -1)) {
        return INT_MAX; // Overflow
    }

    // Determine the signs of dividend and divisor
    int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

    // Convert both dividend and divisor to positive numbers
    long long absDividend = labs((long long)dividend);
    long long absDivisor = labs((long long)divisor);

    // Initialize quotient
    long long quotient = 0;

    // Perform long division
    while (absDividend >= absDivisor) {
        long long temp = absDivisor;
        long long multiple = 1;

        // Find the largest multiple of divisor that can be subtracted from dividend
        while ((temp << 1) <= absDividend) {
            temp <<= 1;
            multiple <<= 1;
        }

        // Subtract the multiple of divisor from dividend
        absDividend -= temp;

        // Update quotient
        quotient += multiple;
    }

    // Apply sign to the quotient
    quotient *= sign;

    // Check for overflow and return the result
    if (quotient > INT_MAX) {
        return INT_MAX;
    } else if (quotient < INT_MIN) {
        return INT_MIN;
    } else {
        return (int)quotient;
    }
}