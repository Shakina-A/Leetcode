#include <stdlib.h>
#include <string.h>

char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) {
        char* result = (char*)malloc(sizeof(char));
        *result = '\0';
        return result;
    }

    int prefixLength = strlen(strs[0]);

    // Iterate through the characters of the first string
    for (int i = 0; i < prefixLength; i++) {
        // Compare the character with the corresponding characters of the other strings
        for (int j = 1; j < strsSize; j++) {
            if (strs[j][i] != strs[0][i] || i >= strlen(strs[j])) {
                // If the characters don't match or we reach the end of any string, return the prefix
                char* result = (char*)malloc(sizeof(char) * (i + 1));
                strncpy(result, strs[0], i);
                result[i] = '\0';
                return result;
            }
        }
    }

    // If all strings are identical or strsSize is 1, return the first string as the common prefix
    return strdup(strs[0]);
}
