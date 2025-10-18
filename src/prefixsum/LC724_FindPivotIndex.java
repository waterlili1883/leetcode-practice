package prefixsum;

public class LC724_FindPivotIndex {
    /**
     * LeetCode 724 - Find Pivot Index
     *
     * Given an integer array nums, find the pivot index where
     * the sum of all numbers to the left equals the sum of all
     * numbers to the right.
     *
     * Approach:
     * 1. Compute the total sum of the array.
     * 2. Iterate through the array, maintaining a running leftSum.
     * 3. At each index i:
     *      - If leftSum == totalSum - leftSum - nums[i],
     *        return i (found the pivot).
     *      - Otherwise, add nums[i] to leftSum and continue.
     * 4. If no pivot index is found, return -1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @author Yuna
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        // Step 1: Compute total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Find pivot index
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
