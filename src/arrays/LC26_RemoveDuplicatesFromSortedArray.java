package arrays;

public class LC26_RemoveDuplicatesFromSortedArray {
    /**
     * Removes duplicates from a sorted array in-place and returns the new length.
     * Uses the two-pointer technique:
     *   - One pointer (n) tracks the position of the last unique element.
     *   - The other pointer (i) scans through the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (in-place modification)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int n = 0; // pointer for the last unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[n] != nums[i]) {
                n++;               // move to next position
                nums[n] = nums[i]; // place the new unique element
            }
        }
        return n + 1; // new length = last index + 1
    }
}
