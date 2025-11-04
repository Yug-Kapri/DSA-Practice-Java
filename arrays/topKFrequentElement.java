// Time complexity: O(nlogk)
// Space complexity: O(n + k)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // If the number of elements equals k, all elements are the most frequent
        if (nums.length == k) {
            return nums;
        }

        // Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each number in the array
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Create a min-heap (PriorityQueue) that sorts by frequency (smallest first)
        // So that the least frequent element is removed when size exceeds k
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Iterate over the elements in the frequency map
        for (int n : map.keySet()) {
            heap.add(n); // Add the number to the heap

            // If heap size exceeds k, remove the least frequent element
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Create an array to store the top k frequent elements
        int ans[] = new int[k];

        // Extract elements from the heap
        // Since it's a min-heap, the most frequent elements will remain
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        // Return the result array containing the top k frequent numbers
        return ans;
    }
}
