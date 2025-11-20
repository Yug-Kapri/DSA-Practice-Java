// Time complexity: O(n)
// Space complexity: O(1)

class Solution {

    // Function to rearrange numbers into the next lexicographically greater permutation
    public void nextPermutation(int[] nums) {

        // Step 1: Find the first index "i" from the end such that nums[i] < nums[i+1]
        // This identifies the pivot point where the order breaks (for next permutation)
        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;   // Move left until we find a number smaller than its next number
        }

        // Step 2: If such an index exists, find the next greater element than nums[i]
        // from the right side and swap them
        if (i >= 0) {
            int j = nums.length - 1;

            // Find first element from the right that is greater than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap them to get a slightly larger number
            swap(nums, i, j);
        }

        // Step 3: Reverse the remaining right side to get the smallest order
        // This ensures the next permutation is the lexicographically smallest possible
        reverse(nums, i + 1);
    }

    // Utility function to swap two elements in the array
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Utility function to reverse the array from index i to the end
    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;

        // Swap start and end and shrink the range
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
