class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            // remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // start adding result after first window
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
