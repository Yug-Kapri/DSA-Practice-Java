// Time complexity: O(n)
// Space complexity: O(n)

// Class containing the solution
class Solution {

    // Method to generate FizzBuzz list up to n
    public List<String> fizzBuzz(int n) {
        
        // Create a list to store the final FizzBuzz output
        List<String> result = new ArrayList<>();
        
        // Loop from 1 to n
        for (int i = 1; i <= n; i++) {
            
            // If number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");   // Add FizzBuzz
            }
            // If number only divisible by 3
            else if (i % 3 == 0) {
                result.add("Fizz");       // Add Fizz
            }
            // If number only divisible by 5
            else if (i % 5 == 0) {
                result.add("Buzz");       // Add Buzz
            }
            // Otherwise, add the number itself as a string
            else {
                result.add(Integer.toString(i));
            }
        }
        
        // Return the final FizzBuzz list
        return result;
    }
}
