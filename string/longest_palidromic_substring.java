// Time complexity: O(n^2)
// Space complexity: O(n)

class Solution {

    // Function to return the longest palindromic substring
    public String longestPalindrome(String s) {

        // Edge case: empty or null string
        if (s == null || s.length() < 1) {
            return "";
        }

        // Variables to store the start and end index of the longest palindrome found
        int left = 0, right = 0;

        // Check every index as a possible center of a palindrome
        for (int i = 0; i < s.length(); i++) {

            // Length of odd-length palindrome centered at i
            int lenOdd = checkPalindrome(s, i, i);

            // Length of even-length palindrome centered between i and i+1
            int lenEven = checkPalindrome(s, i, i + 1);

            // Choose the longer one
            int len = Math.max(lenOdd, lenEven);

            // If new palindrome is longer than the previous best
            if (len > right - left) {
                // Update left and right boundaries of the palindrome
                // Formula adjusts based on odd/even length
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(left, right + 1);
    }

    // Function to expand around center and return palindrome length
    public int checkPalindrome(String s, int left, int right) {

        // Expand while characters match and indices are valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Length of palindrome = right - left - 1
        return right - left - 1;
    }
}
