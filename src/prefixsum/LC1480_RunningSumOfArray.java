package prefixsum;
/**
 * LeetCode 1480. Running Sum of 1D Array
 *
 * Problem:
 * Given an array nums, return the running sum of nums.
 * The running sum of an array is defined as:
 *    runningSum[i] = sum(nums[0] ... nums[i])
 *
 * Intuition:
 * The "running sum" is simply a cumulative total (prefix sum).
 * We traverse the array, maintain a variable `sum`,
 * and store the current cumulative value in the result array.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 */
public class LC1480_RunningSumOfArray {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }
}
