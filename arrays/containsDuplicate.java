// Time complexity: O(n)
// Space complexity: O(n)
  
class Soluton {
  public boolean containsDuplicate(int[] nums) {
    // Create a HasSet to store elements from the array
    HashSet<Integer> number = new HashSet<>();

    // Iterate through each element in the array
    for(int num : nums) {
      // Check if the element is already in the HashSet
      if(number.contains(num)) {
        return true; // Duplicate found
      }
      // Add the element to the HashSet
      number.add(num);
    }
    return false; //No duplicate found
  }
}  
