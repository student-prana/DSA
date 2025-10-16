class Solution {

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int largestArea = 0;
        int area, nse, pse;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int ind = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                area = heights[ind] * (nse - pse - 1);
                largestArea = Math.max(largestArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            nse = n;
            int ind = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            area = heights[ind] * (nse - pse - 1);
            largestArea = Math.max(largestArea, area);
        }

        return largestArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int val = matrix[i][j] - '0'; // convert char to int (0 or 1)
                sum += val;
                if (val == 0) {
                    prefixSum[i][j] = 0;
                    sum = 0;
                } else {
                    prefixSum[i][j] = sum;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = largestRectangleArea(prefixSum[i]);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
