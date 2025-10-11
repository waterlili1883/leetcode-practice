package hashmap;

import java.util.HashSet;

/**
 * LC349 - Intersection of Two Arrays
 *
 * Given two integer arrays nums1 and nums2, return their intersection.
 * Each element in the result must be unique, and the result can be in any order.
 *
 * Approach (HashSet):
 *  - Use a HashSet to store unique elements from nums1.
 *  - Traverse nums2 and check if each element exists in the first set.
 *  - Add common elements to a second set (resultSet) to ensure uniqueness.
 *  - Convert resultSet to an int[] and return.
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 */
public class LC349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        // Store unique elements from nums1
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Store intersection results (unique elements only)
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert HashSet to int[] and return
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
