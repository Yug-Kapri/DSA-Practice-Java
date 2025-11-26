// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {

    // Main function to return the first and last occurrence of target
    public int[] searchRange(int[] nums, int target) {
        // Find the first occurrence
        int first = this.find(nums, target, true);

        // If first is not found, target doesn't exist
        if(first == -1){
            return new int[]{-1, -1};
        }

        // Find the last occurrence
        int last = this.find(nums, target, false);

        return new int[]{first, last};
    }

    // Reusable binary search to find first or last occurrence
    public int find(int[] nums, int target, boolean isFirst){

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid] == target){

                // Check if we are finding first occurrence
                if(isFirst){
                    // If mid is at start OR previous element is not target → first occurrence found
                    if(mid == start || nums[mid - 1] != target){
                        return mid;
                    }
                    // Otherwise, keep searching on the left side
                    end = mid - 1;
                } 
                // Finding last occurrence
                else {
                    // If mid is at end OR next element is not target → last occurrence found
                    if(mid == end || nums[mid + 1] != target){
                        return mid;
                    }
                    // Otherwise, keep searching on the right side
                    start = mid + 1;
                }
            }
            // Move left if mid value is greater than target
            else if(nums[mid] > target){
                end = mid - 1;
            } 
            // Move right if mid value is smaller than target
            else {
                start = mid + 1;
            }
        }

        // If target not found, return -1
        return -1;
    }
}
