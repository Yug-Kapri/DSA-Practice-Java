// Time complexity: O(n^2)
// Space complexity: O(n)

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array so we can use two pointers and easily skip duplicates
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        // Iterate through each number to fix one element of the triplet
        for (int i = 0; i < nums.length; i++) {

            // Since array is sorted, if nums[i] is positive, no triplet can sum to zero
            if (nums[i] > 0) break;

            // Skip duplicate values for the 'i' pointer to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;               // Start of right side
            int right = nums.length - 1;    // End of array

            // Two-pointer approach
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    // Sum too large → decrease it by moving right pointer left
                    right--;
                } else if (sum < 0) {
                    // Sum too small → increase it by moving left pointer right
                    left++;
                } else {
                    // Found a valid triplet
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers to search for next possible triplet
                    left++;
                    right--;

                    // Skip duplicate values for the 'left' pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return list;
    }
}
