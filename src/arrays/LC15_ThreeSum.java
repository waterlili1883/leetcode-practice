package arrays;

import java.util.*;

/**
 * LeetCode 15 - 3Sum
 *
 * This method finds all unique triplets in the array that sum up to zero.
 *
 * Approach:
 * 1. Sort the array to enable the two-pointer technique.
 * 2. Iterate through each element (nums[i]) as the fixed element.
 * 3. For each fixed element, use two pointers (left and right) to find pairs that sum to -nums[i].
 * 4. Skip duplicate elements to ensure uniqueness of triplets.
 *
 * Time Complexity: O(n^2)
 *   - Sorting takes O(n log n)
 *   - The main loop and two-pointer traversal take O(n^2)
 *
 * Space Complexity: O(1)
 *   - Only a few extra variables used (ignoring the output list)
 *
 * Example:
 * Input:  [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * @author Yuna
 */
public class LC15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer traversal
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Step 4: Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
