package prefixsum;

/**
 * LeetCode 1413. Minimum Value to Get Positive Step by Step Sum
 *
 * Problem:
 * Given an integer array nums, find the minimum positive startValue
 * such that the step-by-step sum of startValue + sum(nums[0:i])
 * is always greater than 0.
 *
 * Intuition:
 * The step-by-step total (prefix sum) represents your "health points".
 * Whenever you lose points (negative number), you may drop below zero.
 * To stay alive, you must start with enough initial health.
 * The smallest prefix sum during traversal determines how low you go.
 * If your lowest prefix sum is -4, you need at least 1 - (-4) = 5 to survive.
 *
 * Formula:
 *     startValue = 1 - minPrefixSum
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class LC1413_MinimumValueToGetPositive {

    public int minStartValue(int[] nums) {
        int sum = 0;       // running prefix sum
        int minValue = 0;  // smallest prefix sum encountered

        for (int num : nums) {
            sum += num;
            minValue = Math.min(sum, minValue);
        }

        return 1 - minValue; // add enough to make every step > 0
    }
}
