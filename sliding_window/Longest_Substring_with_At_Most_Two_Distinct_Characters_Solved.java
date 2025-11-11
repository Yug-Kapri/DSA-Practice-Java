// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        // Variable to store the maximum length of valid substring
        int count = 0;

        // Get the length of the input string
        int n = s.length();

        // HashMap to store characters and their frequency in the current window
        Map<Character, Integer> map = new HashMap<>();

        // Left pointer of the sliding window
        int j = 0;

        // Iterate through each character using right pointer 'i'
        for (int i = 0; i < s.length(); i++) {

            // Add the current character to the map or increase its count
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            // If the window contains more than 2 distinct characters, shrink it
            while (map.size() > 2) {

                // Get the leftmost character of the current window
                char c = s.charAt(j);

                // Decrease its frequency as we move the left pointer forward
                map.put(c, map.get(c) - 1);

                // If frequency becomes 0, remove the character from the map
                if (map.get(c) == 0) {
                    map.remove(c);
                }

                // Move the left pointer to reduce the window size
                j++;
            }

            // Update the maximum valid window length
            count = Math.max(count, i - j + 1);
        }

        // Return the length of the longest substring with at most 2 distinct characters
        return count;
    }
}
