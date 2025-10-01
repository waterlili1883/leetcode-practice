package strings;
/**
 * LC557 - Reverse Words in a String III
 *
 * Given a string, reverse the characters of each word while preserving spaces and word order.
 *
 * Approach:
 * - Iterate through each character in the string.
 * - Use a StringBuilder (sb1) to accumulate characters of the current word.
 * - When encountering a space:
 *   - Reverse sb1 and append to the result (sb2), followed by a space.
 *   - Reset sb1 for the next word.
 * - After the loop, handle the last word if it exists.
 * - Return the built result string.
 *
 * Time Complexity: O(n), where n = length of the input string
 * Space Complexity: O(n), for storing the result and temporary builders
 */
public class LC557_ReverseWordsInStringIII {

    /**
     * Reverses characters of each word in the input string.
     *
     * @param s input string
     * @return string with each word reversed, spaces preserved
     */
    public String reverseWords(String s) {
        StringBuilder sb1 = new StringBuilder(); // for building current word
        StringBuilder sb2 = new StringBuilder(); // for building final result
        char[] charArray = s.toCharArray();

        // Iterate through characters
        for (char c : charArray) {
            if (c != ' ') {
                sb1.append(c); // build current word
            } else {
                // Reverse current word and append to result
                sb2.append(sb1.reverse());
                sb2.append(' ');
                sb1.setLength(0); // reset sb1 for next word
            }
        }

        // Append last word if exists
        if (sb1.length() > 0) {
            sb2.append(sb1.reverse());
        }

        return sb2.toString();
    }
}
