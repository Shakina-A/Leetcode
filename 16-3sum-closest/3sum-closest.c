#include <stdlib.h> // for abs function

// Comparison function for qsort
int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int threeSumClosest(int* nums, int numsSize, int target) {
    qsort(nums, numsSize, sizeof(int), compare); // Sort the array
    
    int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum
    
    for (int i = 0; i < numsSize - 2; i++) {
        int left = i + 1;
        int right = numsSize - 1;
        
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            
            if (abs(target - sum) < abs(target - closestSum)) {
                closestSum = sum;
            }
            
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // If the sum is equal to target, return it immediately
                return closestSum;
            }
        }
    }
    
    return closestSum;
}
