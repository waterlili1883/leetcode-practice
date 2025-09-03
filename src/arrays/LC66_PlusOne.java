package arrays;

public class LC66_PlusOne {
    /**
     * Increments the given integer (represented as an array of digits) by one.
     *
     * Approach:
     * - Traverse digits from right to left.
     * - If the current digit is less than 9, simply increment it and return.
     * - If the current digit is 9, set it to 0 and continue carry-over.
     * - If all digits are 9, create a new array with an extra digit at the front (e.g., 999 -> 1000).
     *
     * Time Complexity: O(n)   (traverse the digits once)
     * Space Complexity: O(1)  (in-place modification, except when creating new array for all 9s)
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;  // Increment and return immediately
                return digits;
            } else {
                digits[i] = 0;              // Set to 0 and carry over to next digit
            }
        }

        // If we are here, all digits were 9, so we need a new array
        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;  // Leading 1, rest are 0 by default

        return newArr;
    }
}
