import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> set = new HashMap<>(); // changed

        for (int i = 0; i < nums1.length; i++) {
            set.put(nums1[i], set.getOrDefault(nums1[i], 0) + 1); // changed
        }

        List<Integer> helper = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < nums2.length; i++) {
            if (set.containsKey(nums2[i]) && set.get(nums2[i]) > 0) { // changed
                helper.add(nums2[i]);
                set.put(nums2[i], set.get(nums2[i]) - 1); // fixed
            }
        }

        int size = helper.size();
        int ans[] = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = helper.get(i);
        }

        return ans;
    }
}