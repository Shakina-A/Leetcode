#include <stdlib.h>

int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    if (matrixSize == 0 || *matrixColSize == 0) {
        *returnSize = 0;
        return NULL;
    }
    
    // Initialize boundaries
    int top = 0, bottom = matrixSize - 1;
    int left = 0, right = *matrixColSize - 1;
    
    // Initialize result array
    *returnSize = matrixSize * (*matrixColSize);
    int *result = (int *)malloc(sizeof(int) * (*returnSize));
    int index = 0;
    
    // Traverse in spiral order
    while (top <= bottom && left <= right) {
        // Traverse from left to right along the top row
        for (int i = left; i <= right; ++i) {
            result[index++] = matrix[top][i];
        }
        top++;
        
        // Traverse from top to bottom along the right column
        for (int i = top; i <= bottom; ++i) {
            result[index++] = matrix[i][right];
        }
        right--;
        
        // Traverse from right to left along the bottom row
        if (top <= bottom) { // Check to avoid duplicate traversal
            for (int i = right; i >= left; --i) {
                result[index++] = matrix[bottom][i];
            }
            bottom--;
        }
        
        // Traverse from bottom to top along the left column
        if (left <= right) { // Check to avoid duplicate traversal
            for (int i = bottom; i >= top; --i) {
                result[index++] = matrix[i][left];
            }
            left++;
        }
    }
    
    *returnSize = index; // Set actual size of the result array
    return result;
}
