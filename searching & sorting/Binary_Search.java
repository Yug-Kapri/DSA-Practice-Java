// Time comlexity: O(logn)
//Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // Initialize left and right pointers

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate middle index safely

            // If the middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            } 
            // If target is greater, search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, search in the left half
            else {
                right = mid - 1;
            }
        }

        // If target not found, return -1
        return -1;
    }
}
