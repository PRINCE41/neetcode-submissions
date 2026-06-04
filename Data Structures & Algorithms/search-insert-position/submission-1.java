class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target || target < nums[i]) return i;
            else if(target > nums[i]) res = i+1;
        }
        return res;
    }
}