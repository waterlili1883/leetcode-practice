package hashmap;

import java.util.HashMap;

/**
 * LeetCode 454 - 4Sum II
 *
 * Given four integer arrays nums1, nums2, nums3, and nums4,
 * return the number of tuples (i, j, k, l) such that:
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0.
 *
 * Approach:
 * 1. Use a HashMap to store all possible sums of nums1 and nums2,
 *    along with their frequency (number of occurrences).
 * 2. Then, iterate over all possible sums of nums3 and nums4,
 *    and for each sum, check whether its negation (-sum) exists in the map.
 * 3. If it does, add the corresponding frequency to the count.
 *
 * Example:
 * nums1 = [1, 2]
 * nums2 = [-2, -1]
 * nums3 = [-1, 2]
 * nums4 = [0, 2]
 * Output: 2
 *
 * Time Complexity:  O(n^2)
 *      - Each pair from nums1 and nums2 is computed once.
 *      - Each pair from nums3 and nums4 is computed once.
 *
 * Space Complexity: O(n^2)
 *      - The HashMap stores up to n^2 sums from nums1 and nums2.
 *
 * @author Yuna
 */
public class LC454_4SumII {

    /**
     * Counts the number of quadruples (i, j, k, l) such that
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0.
     *
     * @param nums1 first integer array
     * @param nums2 second integer array
     * @param nums3 third integer array
     * @param nums4 fourth integer array
     * @return total number of quadruples summing to zero
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int count = 0;

        // Step 1: Store all possible sums of nums1 and nums2, with their frequencies
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                result.put(sum, result.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: For each pair in nums3 and nums4, find the complement sum in the map
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (result.containsKey(-sum)) {
                    count += result.get(-sum);
                }
            }
        }

        return count;
    }
}
