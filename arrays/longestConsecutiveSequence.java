class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a HashSet to store all unique numbers from the array.
        // Using a set allows for O(1) average time lookups.
        Set<Integer> numSet = new HashSet<>();

        // Add all numbers from the array into the set.
        for (int num : nums) {
            numSet.add(num);
        }

        // Variable to store the length of the longest consecutive sequence.
        int longest = 0;

        // Iterate through each number in the set.
        for (int num : numSet) {
            // Check if the current number is the start of a sequence.
            // A number is the start if (num - 1) is NOT in the set.
            if (!numSet.contains(num - 1)) {
                int length = 1; // Start counting the current sequence length.

                // Keep checking for consecutive numbers (num + 1, num + 2, ...).
                while (numSet.contains(num + length)) {
                    length++; // Increase the sequence length for each consecutive number found.
                }

                // Update the longest sequence length if the current one is longer.
                longest = Math.max(length, longest);
            }
        }

        // Return the length of the longest consecutive sequence.
        return longest;
    }
}
