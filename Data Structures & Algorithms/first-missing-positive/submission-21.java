class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number at its target index if possible
        // Target index for value 'x' is 'x - 1'
        for (int i = 0; i < n; i++) {
            // While the current number is in the valid range [1, n]
            // AND it's not already at its correct position...
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its target index
                int targetIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIdx];
                nums[targetIdx] = temp;
            }
        }

        // Step 2: Scan the array to find the first index that doesn't match the value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers 1 to n are present, the answer is n + 1
        return n + 1;
    }
}