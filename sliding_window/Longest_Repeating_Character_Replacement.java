// Time complexity: O(26 * n)
// Space complexity: O(1)

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;  // Stores the maximum length of a valid substring

        // Step 1: Store all unique characters from the string in a set
        HashSet<Character> charset = new HashSet<>();
        for (char c : s.toCharArray()) {
            charset.add(c);
        }

        // Step 2: For each unique character, try to make the entire substring consist of that character
        for (char c : charset) {
            int count = 0;  // Counts how many characters in the current window match 'c'
            int left = 0;   // Left pointer for the sliding window

            // Step 3: Expand the window by moving the right pointer
            for (int right = 0; right < s.length(); right++) {
                // If the right character matches the target character 'c', increase count
                if (s.charAt(right) == c) {
                    count++;
                }

                // Step 4: Check if more than 'k' replacements are needed in the current window
                // (window size) - (count of matching chars) gives number of replacements needed
                while ((right - left + 1) - count > k) {
                    // If the left character matches the target, decrease count as it leaves the window
                    if (s.charAt(left) == c) {
                        count--;
                    }
                    left++; // Shrink window from the left
                }

                // Step 5: Update result with the largest valid window length so far
                res = Math.max(res, right - left + 1);
            }
        }

        // Step 6: Return the maximum valid substring length
        return res;
    }
}
