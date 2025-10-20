package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560 - Subarray Sum Equals K
 * Category: Prefix Sum / HashMap
 *
 * Given an array of integers nums and an integer k, return the total number
 * of continuous subarrays whose sum equals to k.
 *
 * Approach:
 * 1. Use prefix sum + HashMap to record how many times each prefix sum appears.
 * 2. For each element:
 *      - Update running sum.
 *      - If (sum - k) exists in map, add its count to the result.
 *      - Increment map[sum].
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Yuna
 */
public class LC560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // base case: empty prefix
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // if there exists a prefix with sum = currentSum - k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // update current prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
