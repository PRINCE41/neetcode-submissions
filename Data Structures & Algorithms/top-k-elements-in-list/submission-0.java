class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        
        return freqMap.entrySet().stream()
            .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
