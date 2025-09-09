package arrays;

public class LC485_MaxConsecutiveOnes {
    /**
     * Finds the maximum number of consecutive 1s in a binary array.
     *
     * Approach:
     * - Use a counter to track the current streak of consecutive 1s.
     * - Use a max variable to store the maximum streak encountered.
     * - Iterate through the array:
     *   - If the element is 1, increment count and update max.
     *   - If the element is 0, reset count to 0.
     *
     * Time Complexity: O(n)   (single pass through the array)
     * Space Complexity: O(1)  (constant extra space)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count += 1;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
