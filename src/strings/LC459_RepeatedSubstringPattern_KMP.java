package strings;

/**
 * LC459 - Repeated Substring Pattern
 *
 * Given a non-empty string, check if it can be constructed by
 * taking a substring of it and appending multiple copies of the substring together.
 *
 * Approach: Knuth-Morris-Pratt (KMP) Algorithm
 * - Build the LPS (Longest Prefix Suffix) array for the string.
 * - If the string is composed of repeated substring(s),
 *   then there exists a proper prefix which is also a suffix.
 * - Let n = length of string, lps[n-1] = length of the longest prefix-suffix.
 * - The length of the repeating substring is (n - lps[n-1]).
 * - If n % (n - lps[n-1]) == 0 and lps[n-1] > 0, then s is a repeated pattern.
 *
 * Time Complexity: O(n), where n = length of string
 * Space Complexity: O(n), for the LPS array
 */
public class LC459_RepeatedSubstringPattern_KMP {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = buildLPS(s);

        int len = lps[n - 1]; // length of longest prefix-suffix
        return (len > 0 && n % (n - len) == 0);
    }

    /**
     * Builds the LPS (Longest Prefix Suffix) array for KMP.
     * lps[i] = the length of the longest proper prefix
     *          which is also a suffix for substring s[0..i]
     */
    private int[] buildLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix-suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // fall back in the LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
