// Time complexity: O(n^2)
// Space complexity: O(1)

class Solution {

    // Function to count all palindromic substrings in the string
    public int countSubstrings(String s) {
        int ans = 0;

        // For every character, try to expand around it
        // Case 1: Odd-length palindrome (center at i)
        // Case 2: Even-length palindrome (center between i and i+1)
        for (int i = 0; i < s.length(); i++) {
            ans += checkPalindrome(s, i, i);     // Odd length
            ans += checkPalindrome(s, i, i + 1); // Even length
        }

        return ans;
    }

    // Helper function that expands around the given left and right indices
    // and counts how many palindromes can be formed
    public int checkPalindrome(String s, int left, int right) {
        int count = 0;

        // Expand while the characters match and indices stay within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;    // Found a new palindrome substring
            left--;     // Expand left
            right++;    // Expand right
        }

        return count;   // Total palindromes found for this center
    }
}
