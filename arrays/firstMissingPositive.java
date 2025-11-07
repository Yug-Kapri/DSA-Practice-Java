// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length; // Length of the array

        int contains = 0;

        // Step 1: Check if the array contains the number '1'
        // Because if '1' is missing, the answer is definitely 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }

        // If '1' is not found, return 1 as the smallest missing positive number
        if (contains == 0) {
            return 1;
        }

        // Step 2: Replace all non-positive numbers (≤0) and numbers greater than n with 1
        // This ensures all numbers in the array are in the range [1, n]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Step 3: Use index marking to record which numbers are present
        // For each number, mark the index corresponding to that number as negative
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]); // Get the absolute value (to handle already marked indices)

            // If the number equals n, mark index 0 as special indicator
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } 
            // Otherwise, mark nums[a] as negative to indicate number 'a' is present
            else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // Step 4: Find the first index whose value is still positive
        // The index represents the smallest missing positive number
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i; // index 'i' means number 'i' is missing
            }
        }

        // Step 5: If index 0 is positive, then 'n' is missing
        if (nums[0] > 0) {
            return n;
        }

        // Step 6: If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }
}
