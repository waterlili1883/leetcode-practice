package strings;

public class LC242_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // Array of size 26 to track character counts ('a' → 0, 'z' → 25)
        int[] arr = new int[26];

        // Increment frequency for each character in s
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        // Decrement frequency for each character in t
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, then s and t are anagrams
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
