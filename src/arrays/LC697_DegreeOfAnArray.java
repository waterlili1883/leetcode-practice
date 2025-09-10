package arrays;

import java.util.HashMap;
import java.util.Map;

public class LC697_DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        // Map to store: number -> [frequency, first index, last index]
        Map<Integer, int[]> map = new HashMap<>();

        // Traverse the array to build the map
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                // First occurrence: frequency = 1, left = right = i
                map.put(nums[i], new int[]{1, i, i});
            } else {
                // Update frequency and rightmost index
                int[] arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
            }
        }

        int degree = 0;              // The degree of the array (max frequency)
        int minLen = nums.length;    // Minimum subarray length

        // Find the minimum subarray length among numbers with max frequency
        for (int[] v : map.values()) {
            if (v[0] > degree) {
                degree = v[0];                  // update degree
                minLen = v[2] - v[1] + 1;       // subarray length
            } else if (v[0] == degree) {
                minLen = Math.min(minLen, v[2] - v[1] + 1);
            }
        }

        return minLen;
    }

}
