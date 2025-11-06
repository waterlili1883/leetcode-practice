package binarysearch;
/**
 * LeetCode 69. Sqrt(x)
 * Approach: Binary Search
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Given a non-negative integer x, return the integer part of its square root.
 * The returned integer is the floor of the actual square root value.
 */
public class LC69_SqrtX {
    /**
     * Compute the integer square root using binary search.
     * @param x input non-negative integer
     * @return floor(sqrt(x))
     */
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right; // right is the floor of sqrt(x)
    }
}
