package strings;

import java.util.HashMap;

public class LC383_RansomNote {
    /**
     * Determines if ransomNote can be constructed from magazine.
     *
     * Approach:
     * - Count the frequency of each character in magazine.
     * - For each character in ransomNote, check if magazine still has enough supply.
     * - If any character is missing or its count is exhausted, return false.
     *
     * Time Complexity: O(m + n), where m = ransomNote.length, n = magazine.length
     * Space Complexity: O(1) (only 26 lowercase letters)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        // Count frequencies of each character in magazine
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // Consume characters from ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (hm.containsKey(c) && hm.get(c) > 0) {
                hm.put(c, hm.get(c) - 1); // use one character
            } else {
                return false; // not enough supply
            }
        }

        return true;
    }
}
