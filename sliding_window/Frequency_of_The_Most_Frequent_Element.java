// Time complexity: O(nlogn)
// Space complexity: O(1)

class Solution {
    public int maxFrequency(int[] nums, int k) {

        // Step 1: Sort the array so we can use sliding window
        // and make all numbers in a window equal to the rightmost number.
        Arrays.sort(nums);

        long total = 0;   // Sum of elements in the current window [l..i]
        int res = 0;      // Stores the maximum frequency found
        int l = 0;        // Left pointer of the sliding window

        // Step 2: Expand the window using right pointer i
        for (int i = 0; i < nums.length; i++) {

            total += nums[i]; // Add current value to window sum

            // Step 3: Check if we can make all elements in window equal to nums[i]
            // Required sum = (window size) * nums[i]
            // We can increase total by at most k (using operations)
            // so the condition must satisfy:
            // (window size * nums[i]) <= total + k
            while ((long) nums[i] * (i - l + 1) > total + k) {

                // If not valid, shrink window from left
                total -= nums[l];
                l++;
            }

            // Step 4: Window is valid now; update maximum frequency
            res = Math.max(res, i - l + 1);
        }

        // Step 5: Return the maximum possible frequency
        return res;
    }
}
