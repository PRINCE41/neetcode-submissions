class Solution {
    public int longestConsecutive(int[] nums) {
        // -1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9
        if(nums.length == 0) return 0;
        int intRes = 1;
        Arrays.sort(nums);
        int result = 0;
        // 2,3,4,4,5,10,20
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                intRes++;
            }
            else if(nums[i] != nums[i-1]){
                if(result<intRes)result = intRes;
                intRes = 1;

            }

            // } else {
            //     result = 1;
            // }
        }
        return Math.max(result, intRes);
    }
}
