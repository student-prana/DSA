class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        odd[n - 1] = true;
        even[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);

        int answer = 1;

        for (int i = n - 2; i >= 0; i--) {

            Integer high = map.ceilingKey(arr[i]);
            if (high != null) {
                odd[i] = even[map.get(high)];
            }

            Integer low = map.floorKey(arr[i]);
            if (low != null) {
                even[i] = odd[map.get(low)];
            }

            if (odd[i]) {
                answer++;
            }

            map.put(arr[i], i);
        }

        return answer;
    }
}