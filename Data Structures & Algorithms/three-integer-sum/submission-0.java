class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> intRes = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(intRes);
                        res.add(intRes);
                    }
                        
                }
            }
        }
        return new ArrayList<>(res);
    }
}
