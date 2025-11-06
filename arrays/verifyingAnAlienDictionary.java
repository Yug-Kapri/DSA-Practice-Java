class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Create a map to store the rank (index) of each character 
        // according to the given 'alien' dictionary order
        Map<Character, Integer> orderMap = new HashMap<>();

        // Fill the map where key = character and value = its index in 'order'
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        // Compare each pair of consecutive words
        for (int i = 0; i < words.length - 1; i++) {
            // Compare characters of the current word and the next word
            for (int j = 0; j < words[i].length(); j++) {
                
                // If next word is shorter but current word is longer
                // and all previous characters are same, then it's not sorted
                if (j >= words[i + 1].length()) {
                    return false;
                }

                // If characters are different, compare their alien order
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentLetter = orderMap.get(words[i].charAt(j));
                    int nextLetter = orderMap.get(words[i + 1].charAt(j));

                    // If the next word’s letter has a smaller rank → not sorted
                    if (nextLetter < currentLetter) {
                        return false;
                    } else {
                        // Otherwise, correct order — stop checking this pair
                        break;
                    }
                }
            }
        }
        // All word pairs are in correct order
        return true;
    }
}
