// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        // i -> buying day pointer
        // j -> selling day pointer
        // n -> total number of days
        // MaxProfit -> stores the maximum profit found so far
        int i = 0, j = 1, n = prices.length, MaxProfit = 0;

        // Traverse the price array with two pointers
        while (j < n) {
            // If current selling price is greater than buying price,
            // calculate profit and update maximum profit if needed
            if (prices[i] < prices[j]) {
                int profit = prices[j] - prices[i];
                MaxProfit = Math.max(MaxProfit, profit);
            } 
            // If the selling price is less than or equal to the buying price,
            // move the buying pointer to the current day (as it's cheaper)
            else {
                i = j;
            }
            // Move the selling pointer to the next day
            j++;
        }    

        // Return the maximum profit possible
        return MaxProfit;
    }
}
