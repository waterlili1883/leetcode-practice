package arrays;

public class LC1365_SmallerNumbersThanCurrent {
    /**
     * Given an array nums, for each nums[i], return the number of elements
     * in the array that are smaller than it.
     *
     * Approach:
     * - Constraints guarantee nums[i] is in range [0, 100].
     * - Use counting array (size 101) to record the frequency of each number.
     * - Build prefix sums so that count[i] tells how many numbers <= i.
     * - For each nums[i], the result is count[nums[i] - 1] (if >0), i.e.,
     *   how many numbers are strictly smaller.
     *
     * Time Complexity: O(n + K), where K = 100 (constant).
     * Space Complexity: O(K) = O(1).
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // frequency array

        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Prefix sum: count[i] = how many numbers <= i
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        // Build result array
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }

        return res;
    }
}
