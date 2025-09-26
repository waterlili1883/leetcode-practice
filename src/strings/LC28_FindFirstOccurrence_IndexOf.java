package strings;

/**
 * LC28 - Find the Index of the First Occurrence in a String
 *
 * Approach: Built-in `indexOf` method
 * - Directly use Java's built-in String method `indexOf` to find
 *   the first occurrence of `needle` in `haystack`.
 * - This is the simplest solution, leveraging the Java standard library.
 *
 * Time Complexity: O(m * n) in the worst case (implementation-dependent).
 * Space Complexity: O(1), no extra space used.
 */
public class LC28_FindFirstOccurrence_IndexOf {

    /**
     * Returns the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // built-in method
    }
}
