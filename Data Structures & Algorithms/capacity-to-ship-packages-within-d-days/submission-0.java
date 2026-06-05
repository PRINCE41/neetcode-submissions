class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight); // minimum capacity
            high += weight;              // maximum capacity
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                usedDays++;
                currentLoad = 0;
            }

            currentLoad += weight;

            if (usedDays > days) {
                return false;
            }
        }

        return true;
    }
}