class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // minimum possible largest sum
            high += num;              // maximum possible largest sum
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSplit(int[] nums, int k, int maxAllowedSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                subarrays++;
                currentSum = 0;
            }

            currentSum += num;

            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }
}