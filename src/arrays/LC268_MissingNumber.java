package arrays;

public class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Expected sum of numbers from 0 to n (inclusive of n)
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of elements in the array
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }

        // The missing number is the difference
        return expectedSum - actualSum;
    }
}
