int search(int* nums, int numsSize, int target) {
    int left = 0;
    int right = numsSize - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target)
            return mid;
        
        // Left half is sorted
        if (nums[left] <= nums[mid]) {
            // Check if target is in the left sorted half
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1; // Target is in the left half
            } else {
                left = mid + 1; // Target is in the right half
            }
        } else { // Right half is sorted
            // Check if target is in the right sorted half
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
    }
    
    return -1; // Target not found
}
