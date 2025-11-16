// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;                        // Pointer at the start of the array
        int right = numbers.length - 1;      // Pointer at the end of the array

        // Use two-pointer technique since the array is sorted
        while (left < right) {

            int curSum = numbers[left] + numbers[right];  // Current sum of both pointers

            // If current sum is smaller than target, move left pointer forward
            if (curSum < target) {
                left++;

            // If current sum is greater than target, move right pointer backward
            } else if (curSum > target) {
                right--;

            // If sum matches target, return the 1-based indices
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }

        // No solution found (problem guarantees one solution, so this won't usually execute)
        return new int[0];
    }
}
