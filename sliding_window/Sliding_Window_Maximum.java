// Time complexity: O(n)
// Space complexity: O(k)

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case: if the input array is empty or k is invalid, return an empty array
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store the maximum of each window
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of useful elements in decreasing order

        // Traverse the entire array
        for (int i = 0; i < n; i++) {

            // Step 1: Remove indices that are out of the current window (i - k + 1)
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Remove from front
            }

            // Step 2: Maintain decreasing order in deque
            // Remove elements smaller than current number from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add the current element's index to the deque
            deque.offer(i);

            // Step 4: Record the maximum for the window when we've processed at least 'k' elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]; // Front of deque is the largest in the window
            }
        }

        // Step 5: Return the array of window maximums
        return result;
    }
}
