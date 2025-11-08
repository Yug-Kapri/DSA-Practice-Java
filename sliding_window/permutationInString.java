// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, it's impossible for s2 to contain a permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays to store the count of each character ('a' to 'z')
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Step 1: Fill frequency counts for s1 and the first window of s2 (of same length as s1)
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++; // Count characters in s1
            s2Map[s2.charAt(i) - 'a']++; // Count characters in the first window of s2
        }

        // Step 2: Slide the window through s2 and check for matching frequency
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // If current window matches s1's character frequency → permutation found
            if (matches(s1Map, s2Map)) {
                return true;
            }

            // Move the window:
            // Add the next character entering the window
            s2Map[s2.charAt(i + s1.length()) - 'a']++;
            // Remove the first character leaving the window
            s2Map[s2.charAt(i) - 'a']--;
        }

        // Step 3: Check the last window (since loop ends before it)
        return matches(s1Map, s2Map);
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false; // Mismatch in character counts
            }
        }
        return true; // All counts match → permutation found
    }
}
