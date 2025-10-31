package strings;

/**
 * LeetCode 9 - Palindrome Number
 *
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example:
 *  Input: x = 121
 *  Output: true
 *
 *  Input: x = -121
 *  Output: false
 *  Explanation: From left to right, it reads -121. From right to left, it becomes 121-, which is not the same.
 *
 * Approach:
 *  - Convert the integer to a string.
 *  - Use two pointers (left and right) to compare characters from both ends.
 *  - If all pairs match, return true; otherwise, false.
 *
 * Time Complexity: O(n), where n is the length of the number.
 * Space Complexity: O(1), ignoring string storage.
 *
 * @author Yuna
 */
public class LC9_PalindromeNumber {

    /**
     * Checks whether the given integer is a palindrome.
     *
     * @param x the integer to check
     * @return true if x is a palindrome, false otherwise
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (e.g., -121)
        if (x < 0) return false;

        String temp = Integer.toString(x);
        int left = 0;
        int right = temp.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
