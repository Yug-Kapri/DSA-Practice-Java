// Time Complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int scoreOfString(String s) {
        // Initialize a variable to store the total score
        int score = 0;

        // Loop through the string from the first to the second-last character
        for (int i = 0; i < s.length() - 1; i++) {
            // Calculate the absolute difference between the ASCII values 
            // of the current character and the next character
            score += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }

        // Return the total score
        return score;
    }
}
