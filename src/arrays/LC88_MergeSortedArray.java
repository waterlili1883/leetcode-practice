package arrays;

public class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1: index of the last valid element in nums1
        // p2: index of the last element in nums2
        // p : index of the last position in nums1 (where we write the merged result)
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // Compare elements from the back of nums1 and nums2
        // Place the larger one at nums1[p], then move pointers accordingly
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are remaining elements in nums2,
        // copy them into nums1 (nums1's remaining part is already in place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

}
