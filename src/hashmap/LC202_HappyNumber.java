package hashmap;

import java.util.HashSet;

/**
 * LeetCode 202 - Happy Number
 * Determine whether a number eventually reaches 1 when repeatedly replaced by
 * the sum of the squares of its digits. Uses a HashSet to detect cycles.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 */
public class LC202_HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            // If number already seen, a cycle is detected
            if (!seen.add(n)) {
                return false;
            }
            // Replace n with the sum of squares of its digits
            n = getSumOfSquares(n);
        }

        return true; // Reached 1 → Happy number
    }

    /** Helper method to compute the sum of squares of digits */
    public int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}

