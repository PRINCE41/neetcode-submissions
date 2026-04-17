class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int best = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            best = Math.max(best, h * w);

            if (height[l] < height[r]) l++;
            else r--;
        }
        return best;
    }
}
