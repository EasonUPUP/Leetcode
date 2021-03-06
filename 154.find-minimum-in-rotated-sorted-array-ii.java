/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left += 1;
                right -= 1;
            }
            else if (nums[mid] <= nums[right])
            // Case 1) Right side sorted, left side has pivot (minval), go left to find it
            // Case 2) Both sides sorted, go left to find the smallest value (minval)
                right = mid;
            else
            // Case 1) Left side sorted, right side has pivot (minval), go right to find it
                left = mid + 1;
        }
    return nums[left];
    }
}
// @lc code=end

