package strings;

/**
 * LC680_ValidPalindromeII
 *
 * Given a string s, return true if the string can be a palindrome
 * after deleting at most one character.
 *
 * Approach:
 * - Use two pointers (left, right) to compare characters from both ends.
 * - When a mismatch occurs, try skipping one character:
 *      1. Skip the left character (left+1 ... right)
 *      2. Skip the right character (left ... right-1)
 * - If either case forms a palindrome, return true.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LC680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if (c1 != c2) { // mismatch found
                boolean validSkipLeft = isValid(s, left + 1, right);   // skip left char
                boolean validSkipRight = isValid(s, left, right - 1);  // skip right char
                return validSkipLeft || validSkipRight;
            }

            left++;   // move left pointer
            right--;  // move right pointer
        }

        return true; // all matched → valid palindrome
    }

    // helper method: check if substring s[left...right] is palindrome
    public boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
