class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && stack[top] > nums[i] && top + (n - i) >= k) {
                top--;
            }
            if (top + 1 < k) {
                stack[++top] = nums[i];
            }
        }

        return stack;
    }
}