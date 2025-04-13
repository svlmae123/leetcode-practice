class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int half = (m + n + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            // Handle edges: use MIN/MAX for empty sides
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Found correct partition
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }
            // Move left in nums1
            else if (left1 > right2) {
                right = i - 1;
            }
            // Move right in nums1
            else {
                left = i + 1;
            }
        }

        // No need for exception handling, just return 0 or a placeholder
        return 0.0;
    }
}