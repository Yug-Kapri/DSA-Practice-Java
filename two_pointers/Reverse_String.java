// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public void reverseString(char[] s) {
        int left = 0;                  // Pointer starting from the beginning
        int right = s.length - 1;      // Pointer starting from the end

        // Swap characters while left pointer is before right pointer
        while (left < right) {
            char temp = s[left];       // Temporarily store left character
            s[left] = s[right];        // Move right character to left side
            s[right] = temp;           // Place stored left character to right side

            left++;    // Move left pointer forward
            right--;   // Move right pointer backward
        }
    }
}
