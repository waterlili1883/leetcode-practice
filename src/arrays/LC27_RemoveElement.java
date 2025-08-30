package arrays;

public class LC27_RemoveElement {

    // Remove all occurrences of `val` in-place and return the new length.
    // Uses two-pointer overwrite pattern (stable: preserves the relative order).
    // Time: O(n), Space: O(1)
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer: next write position for a kept element
        for (int j = 0; j < nums.length; j++) { // fast pointer: scan every element
            if (nums[j] != val) {              // keep elements that are not `val`
                nums[i] = nums[j];             // overwrite at the slow pointer
                i++;                           // advance write position
            }
        }
        return i; // new length = number of kept elements
    }
}
