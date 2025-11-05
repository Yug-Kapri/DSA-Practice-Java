// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int[] getConcatenation(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Create a new array 'ans' of size 2 * n
        // It will store two copies of the original array back-to-back
        int ans[] = new int[2 * n];

        // Loop through the input array
        for (int i = 0; i < n; i++) {
            // Place the current element in the first half and the second half
            ans[i] = nums[i];     // First copy
            ans[i + n] = nums[i]; // Second copy
        }

        // Return the concatenated array
        return ans;
    }
}
