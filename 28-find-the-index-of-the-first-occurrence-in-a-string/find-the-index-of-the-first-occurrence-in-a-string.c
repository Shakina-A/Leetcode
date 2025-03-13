#include <string.h>

int strStr(char* haystack, char* needle) {
    int haystackLen = strlen(haystack);
    int needleLen = strlen(needle);
    
    if (needleLen == 0) {
        return 0; // Empty needle is always found at index 0
    }
    
    if (haystackLen < needleLen) {
        return -1; // Needle cannot be found if it's longer than haystack
    }
    
    for (int i = 0; i <= haystackLen - needleLen; i++) {
        int j;
        for (j = 0; j < needleLen; j++) {
            if (haystack[i + j] != needle[j]) {
                break; // Characters don't match, move to the next starting index
            }
        }
        if (j == needleLen) {
            return i; // Found needle starting at index i
        }
    }
    
    return -1; // Needle not found
}
