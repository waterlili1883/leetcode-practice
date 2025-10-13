package hashmap;

import java.util.*;

public class LC49_GroupAnagrams {
    /**
     * LeetCode 49 - Group Anagrams
     *
     * This method groups a list of strings into groups of anagrams.
     * An anagram is defined as words that contain the same characters
     * but may appear in a different order (e.g., "eat", "tea", "ate").
     *
     * Approach:
     * 1. Use a HashMap to store <sortedString, List of words>.
     * 2. For each word in the input array:
     *      - Sort the characters of the word to generate a key.
     *      - If the key doesn't exist in the map, create a new list.
     *      - Otherwise, append the word to the existing list.
     * 3. Return all the grouped lists as the result.
     *
     * Time Complexity:  O(n * k log k)
     *      n = number of words, k = average word length
     *      Sorting each word takes O(k log k)
     *
     * Space Complexity: O(n * k)
     *      for storing grouped strings in HashMap
     *
     * @author Yuna
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group words by their sorted string key
        HashMap<String, List<String>> hm = new HashMap<>();

        // Step 1: Build the map
        for (String str : strs) {
            // Convert string to char array and sort to get the canonical key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);

            // Step 2: Group words with the same key
            if (!hm.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(s, list);
            } else {
                List<String> list = hm.get(s);
                list.add(str);
            }
        }

        // Step 3: Collect grouped anagrams
        List<List<String>> result = new ArrayList<>(hm.values());
        return result;
    }

}
