class Solution {
    public int maxChunksToSorted(int[] arr) {
        int answer = 0;
        int currentMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            }

            if (currentMax == i) {
                answer++;
            }
        }

        return answer;
    }
}