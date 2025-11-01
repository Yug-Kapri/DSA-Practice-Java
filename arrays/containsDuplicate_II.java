// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store each number and its latest index
        HashMap<Integer, Integer> window = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the number already exists in the map
            // and the difference between current and stored index ≤ k
            if (window.containsKey(nums[i]) && i - window.get(nums[i]) <= k) {
                // Duplicate found within the allowed distance
                return true;
            }

            // Update (or add) the number with its current index
            window.put(nums[i], i);
        }

        // No nearby duplicates found
        return false;
    }
}
