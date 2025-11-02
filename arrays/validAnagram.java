// Time complexity: O(n+m)
// Space complexity: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        // If the lengths are not equal, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create two HashMaps to store the frequency of each character
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        // Loop through both strings and count character occurrences
        for (int i = 0; i < s.length(); i++) {
            // Increment the count of character s[i] in countS
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);

            // Increment the count of character t[i] in countT
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Compare both HashMaps — if equal, strings are anagrams
        return countS.equals(countT);
    }
}
