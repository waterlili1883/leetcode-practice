package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 18. 4Sum
 *
 * Given an integer array nums and an integer target, return all unique quadruplets [a, b, c, d]
 * such that a + b + c + d == target.
 *
 * Approach:
 * 1. Sort the array to handle duplicates and apply two-pointer search.
 * 2. Fix two numbers (i, j) and move two pointers (left, right) to find pairs that sum to target.
 * 3. Skip duplicates for i, j, left, and right to ensure unique quadruplets.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(1) (excluding output list)
 *
 * @author Yuna
 */
public class LC18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort array to simplify duplicate handling
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                // Step 2: Use two pointers to find remaining two numbers
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--; // Need smaller sum → move right pointer left
                    } else if (sum < target) {
                        left++; // Need larger sum → move left pointer right
                    } else {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Step 3: Skip duplicate left/right values
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
