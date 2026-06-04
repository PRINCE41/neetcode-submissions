class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = rightBoundary - leftBoundary - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
