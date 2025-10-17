package prefixsum;

import java.util.*;

/**
 * LeetCode 303. Range Sum Query - Immutable
 *
 * Design a class NumArray that supports multiple range-sum queries on an immutable array.
 *
 * Approach:
 * Build a prefix-sum array where prefixSum[i] stores the sum of the first i elements.
 * Then any range sum [left, right] can be answered in O(1) as:
 *   prefixSum[right + 1] - prefixSum[left]
 *
 * Time Complexity:
 *  - Constructor: O(n)
 *  - sumRange():  O(1)
 *
 * Space Complexity: O(n) for the prefix sum array.
 *
 * Author: Yuna
 */
public class LC303_RangeSumQueryImmutable {

    // The inner class as required by the problem statement
    class NumArray {
        // prefixSum[i] = sum of nums[0 .. i-1]; prefixSum has length n+1
        private int[] prefixSum;

        public NumArray(int[] nums) {
            // Allocate one extra slot so prefixSum[0] = 0 (empty prefix)
            prefixSum = new int[nums.length + 1];

            // Build prefix sums: prefixSum[i+1] = prefixSum[i] + nums[i]
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        // Return sum of nums[left .. right] inclusive
        public int sumRange(int left, int right) {
            // Inclusive range → shift right by one on the prefix array
            // Sum = prefix up to right+1 minus prefix up to left
            return prefixSum[right + 1] - prefixSum[left];
        }
    }
}
