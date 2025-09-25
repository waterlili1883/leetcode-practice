package strings;

/**
 * LC28 - Find the Index of the First Occurrence in a String
 *
 * Approach: Knuth-Morris-Pratt (KMP) Algorithm
 * - Preprocess the needle to build the LPS (longest prefix suffix) array.
 * - Use the LPS array to skip unnecessary comparisons after a mismatch.
 * - Guarantees linear time complexity by avoiding re-checking characters.
 *
 * Time Complexity: O(m + n), where
 *   m = length of haystack,
 *   n = length of needle
 * Space Complexity: O(n), for the LPS array
 */
public class LC28_FindFirstOccurrence {

    /**
     * Returns the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        // Build LPS (longest prefix suffix) array for the needle
        int[] lps = buildLPS(needle);

        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                // Found full match
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    // Use LPS to skip re-checking characters
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // no match found
    }

    /**
     * Builds the LPS (longest prefix suffix) array for KMP.
     * lps[i] = the longest proper prefix of substring(0..i)
     *          which is also a suffix of substring(0..i).
     */
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;    // start from the second character

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    // Fall back in the prefix
                    len = lps[len - 1];
                } else {
                    // No prefix-suffix match
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
