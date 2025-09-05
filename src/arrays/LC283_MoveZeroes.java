package arrays;

public class LC283_MoveZeroes {
    /**
     * Moves all zeros in the array to the end while maintaining
     * the relative order of non-zero elements.
     *
     * Approach: Two-pointer (in-place swap)
     * - Use pointer k to track the position to place the next non-zero element.
     * - Traverse the array:
     *   - If nums[i] != 0, swap nums[i] with nums[k] (only if i != k).
     *   - Increment k after placing a non-zero.
     * - This ensures non-zero elements remain in their relative order,
     *   and zeros are pushed to the end.
     *
     * Time Complexity: O(n)   (single pass through the array)
     * Space Complexity: O(1)  (in-place, no extra array used)
     */
    public void moveZeroes(int[] nums) {
        int k = 0; // pointer for the next non-zero position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) { // swap only when positions differ
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                k++;
            }
        }
    }
}
