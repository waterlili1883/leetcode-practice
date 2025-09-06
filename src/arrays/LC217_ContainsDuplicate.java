package arrays;

import java.util.HashSet;

public class LC217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // HashSet to track seen numbers
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through each number in the array
        for (int num : nums) {
            // If add() returns false, the number already exists → duplicate found
            if (!seen.add(num)) {
                return true;
            }
        }

        // No duplicates found
        return false;
    }

}
