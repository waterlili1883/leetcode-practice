package strings;

/**
 * LC459 - Repeated Substring Pattern
 *
 * Given a non-empty string, check if it can be constructed
 * by taking a substring of it and appending multiple copies of the substring together.
 *
 * Approach:
 * - Concatenate the string with itself -> s + s
 * - Remove the first and last character
 * - If the original string still exists inside, it means it is made of repeated substring
 *
 * Time Complexity: O(n)  (string concatenation + search)
 * Space Complexity: O(n) (for the concatenated string)
 */
public class LC459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Check if s is found in the middle of doubled
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
