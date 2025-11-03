class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Create an array to store the final answer
        int ans[] = new int[nums.length];
        
        // Initialize prefix and postfix products as 1
        int pre = 1, post = 1;

        // Initially fill the answer array with 1s
        Arrays.fill(ans, 1);

        // First pass: calculate prefix products
        // For each element, store the product of all elements to its left
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre;       // Assign current prefix product to ans[i]
            pre = nums[i] * pre; // Update prefix product by multiplying current number
        }

        // Second pass: calculate postfix products
        // Traverse from right to left, multiplying each ans[i] with the product of all elements to its right
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= post;      // Multiply current value with postfix product
            post = nums[i] * post; // Update postfix product
        }

        // Return the final array where each element is the product of all other elements
        return ans;
    }
}
