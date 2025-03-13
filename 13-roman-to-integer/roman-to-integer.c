int romanToInt(char* s) {
    int values[26] = {0};
    values['I' - 'A'] = 1;
    values['V' - 'A'] = 5;
    values['X' - 'A'] = 10;
    values['L' - 'A'] = 50;
    values['C' - 'A'] = 100;
    values['D' - 'A'] = 500;
    values['M' - 'A'] = 1000;

    int result = 0;
    int prev = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int current = values[s[i] - 'A'];
        result += current;

        // If the current value is greater than the previous,
        // it means subtraction is involved.
        if (current > prev) {
            // Subtract twice the previous value
            result -= 2 * prev;
        }
        
        prev = current;
    }

    return result;
}