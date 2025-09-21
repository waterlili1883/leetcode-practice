package strings;

import java.util.HashMap;

public class LC242_ValidAnagram_HashMap {
    public static boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // HashMap to store character frequencies from string s
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency for each character in t
        for (char c : t.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == null) {
                // Character not found in map -> not an anagram
                return false;
            }
            if (cnt == 1) {
                // Last occurrence removed, clean up to keep map small
                map.remove(c);
            } else {
                // Decrement count
                map.put(c, cnt - 1);
            }
        }

        // If map is empty, all counts matched -> s and t are anagrams
        return map.isEmpty();
    }

}
