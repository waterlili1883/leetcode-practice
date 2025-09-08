package arrays;

import java.util.HashSet;
import java.util.Set;

public class LC219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) return false;

        // HashSet to store elements in the sliding window
        // Preallocate capacity to reduce rehashing (optional optimization)
        Set<Integer> win = new HashSet<>(Math.min(nums.length, k) * 2);

        for (int i = 0; i < nums.length; i++) {
            // Maintain window size: remove the element that falls out of range (i - k - 1)
            if (i > k) win.remove(nums[i - k - 1]);

            // If current number already exists in the window → duplicate found
            if (!win.add(nums[i])) return true;
        }

        // No duplicates found within distance k
        return false;
    }

}
