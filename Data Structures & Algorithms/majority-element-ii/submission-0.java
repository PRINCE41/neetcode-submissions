

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int l = nums.length;
        Map<Integer, Long> map = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(x -> x,Collectors.counting()));

        return map.entrySet().stream()
            .filter(x -> x.getValue() > l/3)
            .map(x -> x.getKey())
            .collect(Collectors.toList());


        
    }
}