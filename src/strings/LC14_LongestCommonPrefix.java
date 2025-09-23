package strings;

public class LC14_LongestCommonPrefix {
    /**
     * Finds the longest common prefix among an array of strings.
     *
     * Approach (Vertical Scanning):
     * - Iterate character by character over the first string.
     * - For each character, check if all other strings have the same character at that index.
     * - If mismatch or string ends, return the prefix up to this index.
     *
     * Time Complexity: O(m * n), where m = length of the shortest string, n = number of strings
     * Space Complexity: O(1), only constant extra space
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Iterate column by column (character index i)
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); // character to compare

            // Check this character against all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index out of bounds OR mismatch found
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i); // return prefix up to i
                }
            }
        }
        // If all characters in strs[0] match, return it entirely
        return strs[0];
    }
}
