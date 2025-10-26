package prefixsum;

public class LC1422_MaximumScoreAfterSplittingAString {
    /**
     * LeetCode 1422. Maximum Score After Splitting a String
     *
     * Problem:
     * Given a binary string s, split it into two non-empty parts (left and right).
     * The score is defined as:
     *      (number of '0's in the left) + (number of '1's in the right)
     * Return the maximum possible score after a valid split.
     *
     * Intuition:
     * - Initially, all '1's are on the right side.
     * - Traverse the string (except the last char):
     *     - If we see '0', it contributes to the left score (+1).
     *     - If we see '1', it leaves the right side (−1 to right score).
     * - Keep track of the current combined score and update the maximum.
     *
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     */
    public int maxScore(String s) {
        int ones = 0; // total number of '1's in the whole string
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        int maxScore = 0;
        int leftScore = 0;

        // iterate until the second-last character (right part must be non-empty)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') leftScore++;
            else ones--;

            maxScore = Math.max(maxScore, leftScore + ones);
        }

        return maxScore;
    }
}
