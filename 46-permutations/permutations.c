/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
void backtrack(int* nums, int numsSize, int* used, int* current, int index, int** result, int* count) {
    if (index == numsSize) {
        result[*count] = (int*)malloc(numsSize * sizeof(int));
        memcpy(result[*count], current, numsSize * sizeof(int));
        (*count)++;
        return;
    }
    
    for (int i = 0; i < numsSize; ++i) {
        if (!used[i]) {
            used[i] = 1;
            current[index] = nums[i];
            backtrack(nums, numsSize, used, current, index + 1, result, count);
            used[i] = 0;
        }
    }
}

int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    // Calculate number of permutations (n!)
    int totalPermutations = 1;
    for (int i = 1; i <= numsSize; ++i) {
        totalPermutations *= i;
    }
    
    // Allocate memory for result array and column sizes
    int** result = (int**)malloc(totalPermutations * sizeof(int*));
    *returnColumnSizes = (int*)malloc(totalPermutations * sizeof(int));
    *returnSize = 0;
    
    // Temporary arrays for backtracking
    int* used = (int*)calloc(numsSize, sizeof(int));
    int* current = (int*)malloc(numsSize * sizeof(int));
    
    // Perform backtracking to generate permutations
    backtrack(nums, numsSize, used, current, 0, result, returnSize);
    
    // Set column sizes for each permutation
    for (int i = 0; i < *returnSize; ++i) {
        (*returnColumnSizes)[i] = numsSize;
    }
    
    // Free temporary arrays
    free(used);
    free(current);
    
    return result;
}
