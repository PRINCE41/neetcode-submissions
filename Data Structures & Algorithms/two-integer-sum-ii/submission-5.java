class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int[] res = new int[2];
        // for(int i=0; i<numbers.length; i++){
            
        //     for(int j=0; j<numbers.length; j++){
        //         if(i!=j && numbers[i] + numbers[j] == target){
        //             res[0] = j+1;
        //             res[1] = i+1;
        //         }
        //     }  
        // }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            int sub = target - numbers[i];
            if(map.containsKey(sub))
                return new int[]{map.get(sub), i+1};
            map.put(numbers[i], i+1);
        }
        return new int[0];
    }
}
