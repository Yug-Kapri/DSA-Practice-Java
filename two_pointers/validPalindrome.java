// Time complexity: O(n)
// Space complexity: O(1)

class Solution {

    // Function to check if a given string is a palindrome (ignoring non-alphanumeric characters)
    public boolean isPalindrome(String s) {

        int left = 0;                     // Pointer starting from the left
        int right = s.length() - 1;       // Pointer starting from the right

        // Process until both pointers cross
        while(left < right){

            // Move left pointer forward until it lands on an alphanumeric character
            while(left < right && !alphaNum(s.charAt(left))){
                left++;
            }

            // Move right pointer backward until it lands on an alphanumeric character
            while(right > left && !alphaNum(s.charAt(right))){
                right--;
            }

            // Compare characters in lowercase (case insensitive)
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;            // Mismatch -> not a palindrome
            }

            left++;                      // Move both pointers inward
            right--;
        }

        return true;                     // All checks passed -> palindrome
    }

    // Helper function to check if a character is alphanumeric (A–Z, a–z, 0–9)
    public boolean alphaNum(char c){
        return (c >= 'A' && c <= 'Z' ||   // Uppercase letters
                c >= 'a' && c <= 'z' ||   // Lowercase letters
                c >= '0' && c <= '9');    // Digits
    }
}
