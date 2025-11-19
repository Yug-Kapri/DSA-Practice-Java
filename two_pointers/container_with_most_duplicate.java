// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        // Variable to store the maximum water area found
        int max = 0;

        // Two pointers: one at the beginning, one at the end
        int left = 0, right = height.length - 1;

        // Loop until the two pointers meet
        while (left < right) {

            // Width between the two lines
            int width = right - left;

            // Height of container is the minimum of the two lines
            int area = Math.min(height[left], height[right]) * width;

            // Update maximum area if current area is larger
            max = Math.max(area, max);

            // Move the pointer pointing to the shorter line
            // because moving the taller line won't help increase area
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum area found
        return max;
    }
}
