package arrays;

public class LC169_MajorityElement {

    /**
     * Finds the majority element in an array.
     * The majority element is defined as the element that appears
     * more than n/2 times, and it is guaranteed to exist.
     *
     * Approach: Boyer-Moore Voting Algorithm
     * - Maintain a candidate and a counter.
     * - If count is 0, choose the current element as the new candidate and set count = 1.
     * - If the current element equals the candidate, increment count.
     * - Otherwise, decrement count (cancel out a vote).
     * - At the end, the candidate is the majority element.
     *
     * Time Complexity: O(n)   (single pass through the array)
     * Space Complexity: O(1)  (only two variables used)
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;              // new candidate chosen
            } else if (candidate == nums[i]) {
                count++;                // support current candidate
            } else {
                count--;                // cancel out a vote
            }
        }

        return candidate;
    }
}
