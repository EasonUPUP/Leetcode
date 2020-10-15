/*
*   This question is pretty like Check if LinkedList has circle
*   How to decide nextPos and movement direction should remember.
*/

class Solution {
    /**
     * @param{int[]} nums
     * @return{boolean}
     */
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;
        for (int i = 0; i < nums.length; i++){
            int slow = i;
            int fast = nextPos(slow, nums);
            // check if the movements in a cycle all follow a single direction, if all positive/ negative, it follows.
            while ((nums[i] * nums[slow] > 0) && (nums[i] * nums[fast] > 0) && (nums[i] * nums[nextPos(fast, nums)] > 0)){
                if (slow == fast){
                    // check if the cycle size is 1
                    if  (fast == nextPos(fast, nums))
                        break;
                    return true;
                }
                slow = nextPos(slow, nums); // slow = slow.next;
                fast = nextPos(nextPos(fast, nums), nums); // fast = fast.next.next;
            }
        }
        return false;
    }

    private int nextPos(int now, int[] nums){
        int next = now + nums[now];
        return next >= 0 ? (next % nums.length) : (nums.length + next % nums.length);
    }
}
