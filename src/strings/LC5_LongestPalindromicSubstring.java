package strings;

/**
 * LeetCode 5. Longest Palindromic Substring
 * Approach: Expand Around Center
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Given a string s, return the longest palindromic substring in s.
 * A palindrome is a string that reads the same forward and backward.
 */
public class LC5_LongestPalindromicSubstring {

    /**
     * Find the longest palindromic substring using center expansion.
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0; // starting index of the longest palindrome
        int end = 0;   // ending index of the longest palindrome

        // Iterate through each character and expand around both odd and even centers
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd-length palindrome
            int len2 = expandFromCenter(s, i, i + 1); // even-length palindrome
            int len = Math.max(len1, len2);

            // Update boundaries if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // substring() uses exclusive end index, so add +1
        return s.substring(start, end + 1);
    }

    /**
     * Expand from the given center and return the length of the palindrome.
     * @param s input string
     * @param left left boundary
     * @param right right boundary
     * @return length of the palindrome found
     */
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // when loop ends, left and right are one step beyond the palindrome
        return right - left - 1;
    }
}
