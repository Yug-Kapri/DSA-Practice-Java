// Time complexity: O(n)
// Space complexity: O(1)

class Solution {

    // Static map to store Roman numeral symbols and their integer values
    static Map<String, Integer> values = new HashMap<>();

    // Static block initializes the map once when the class is loaded
    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        // Special subtractive cases (e.g., IV = 4, IX = 9)
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {
        int sum = 0; // Final integer result
        int i = 0;   // Pointer to traverse the string

        // Iterate through the string
        while (i < s.length()) {
            // Check if a two-character symbol exists (like "IV" or "CM")
            if (i < s.length() - 1) {
                String twoSymbols = s.substring(i, i + 2);
                if (values.containsKey(twoSymbols)) {
                    // If it's a valid two-symbol numeral, add its value
                    sum += values.get(twoSymbols);
                    i += 2; // Skip two characters
                    continue;
                }
            }

            // Otherwise, handle single Roman numeral symbol
            String oneSymbol = s.substring(i, i + 1);
            sum += values.get(oneSymbol);
            i += 1;
        }

        return sum; // Return the final integer value
    }
}
