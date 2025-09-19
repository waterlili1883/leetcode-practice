package strings;

public class LC844_BackspaceStringCompare {

    /**
     * LC844 - Backspace String Compare
     *
     * Problem:
     * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
     * '#' means a backspace character.
     *
     * Approach:
     * Two-pointer scan from the end of each string, tracking backspaces.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1; // pointer for s
        int j = t.length() - 1; // pointer for t
        int skipS = 0; // number of backspaces to apply in s
        int skipT = 0; // number of backspaces to apply in t

        while (i >= 0 || j >= 0) {
            // Process backspaces in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break; // found a valid character
                }
            }

            // Process backspaces in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break; // found a valid character
                }
            }

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false; // mismatch
                }
            } else if (i >= 0 || j >= 0) {
                // One string has characters left while the other doesn't
                return false;
            }

            // Move both pointers
            i--;
            j--;
        }
        return true;
    }

}
