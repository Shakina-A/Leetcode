#include <stdio.h>
#include <stdlib.h>

// Helper function to compare integers (for qsort)
int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

// Helper function to perform DFS/backtracking
void dfs(int* nums, int numsSize, int* used, int* current, int** result, int* returnSize, int* returnColumnSizes, int depth) {
    if (depth == numsSize) {
        // Allocate memory for the current permutation
        result[*returnSize] = (int*)malloc(numsSize * sizeof(int));
        for (int i = 0; i < numsSize; ++i) {
            result[*returnSize][i] = current[i];
        }
        returnColumnSizes[*returnSize] = numsSize;
        (*returnSize)++;
        return;
    }
    
    for (int i = 0; i < numsSize; ++i) {
        if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
            continue; // Skip used elements or skip duplicates
        }
        used[i] = 1;
        current[depth] = nums[i];
        dfs(nums, numsSize, used, current, result, returnSize, returnColumnSizes, depth + 1);
        used[i] = 0;
    }
}

int** permuteUnique(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    // Sort nums array to handle duplicates
    qsort(nums, numsSize, sizeof(int), compare);
    
    // Allocate memory for result array of arrays
    int** result = (int**)malloc(10000 * sizeof(int*)); // Assume a reasonable max size
    // Allocate memory for returnColumnSizes
    *returnColumnSizes = (int*)malloc(10000 * sizeof(int));
    
    // Tracking variables
    int* current = (int*)malloc(numsSize * sizeof(int));
    int* used = (int*)calloc(numsSize, sizeof(int)); // 0 initialized
    
    *returnSize = 0;
    dfs(nums, numsSize, used, current, result, returnSize, *returnColumnSizes, 0);
    
    // Free memory
    free(current);
    free(used);
    
    return result;
}
