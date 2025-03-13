char* countAndSay(int n) {
    // Base case
    if (n == 1) {
        char* result = (char*) malloc(sizeof(char) * 2);
        strcpy(result, "1");
        return result;
    }
    
    // Recursive case
    char* prev = countAndSay(n - 1);
    int len = strlen(prev);
    
    // Allocate memory for the worst case scenario (each digit and count is unique)
    char* result = (char*) malloc(sizeof(char) * (2 * len + 1));
    int index = 0;
    
    // Traverse the previous result to generate the current one
    for (int i = 0; i < len; ) {
        char current = prev[i];
        int count = 0;
        
        // Count consecutive occurrences of current character
        while (i < len && prev[i] == current) {
            count++;
            i++;
        }
        
        // Append count and current character to the result
        result[index++] = count + '0';  // convert count to char
        result[index++] = current;
    }
    
    // Null terminate the result string
    result[index] = '\0';
    
    // Free memory allocated for previous result
    free(prev);
    
    return result;
}