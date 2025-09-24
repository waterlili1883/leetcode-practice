package strings;

public class LC14_LongestCommonPrefix_Horizontal {
    /**
     * Finds the longest common prefix among an array of strings.
     *
     * Approach (Horizontal Scanning):
     * - Assume the first string as the initial prefix.
     * - For each string, check if it starts with the current prefix.
     * - If not, shorten the prefix from the end until it matches or becomes empty.
     * - Stop early if prefix becomes empty.
     *
     * Time Complexity: O(m * n),
     *   where m = length of the prefix (worst-case length of first string),
     *         n = number of strings
     * Space Complexity: O(1), only constant extra space.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];  // assume the first string is the prefix
        for (int i = 1; i < strs.length; i++) {
            // While current string does not start with prefix, shorten prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
