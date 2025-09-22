package strings;

public class LC387_FirstUniqueCharacterInAString {

    /**
     * Finds the index of the first non-repeating character in a string.
     *
     * Approach:
     * - Count the frequency of each character using an array of size 26.
     * - Iterate through the string again to find the first index
     *   where the character count equals 1.
     *
     * Time Complexity: O(n), where n = s.length()
     * Space Complexity: O(1), since only 26 lowercase letters
     */
    public static int firstUniqChar(String s) {
        int[] count = new int[26]; // frequency array

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find the first index with count == 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // no unique character found
    }


}
