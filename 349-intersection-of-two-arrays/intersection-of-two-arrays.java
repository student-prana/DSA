class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
            List<Integer> helper=new ArrayList<>();
        int count=0;
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                helper.add(nums2[i]);
                set.remove(nums2[i]);
              

                
                
            }
        }
        int size=helper.size();
        int ans[]=new int[size];
        for(int i=0;i<size;i++){
            ans[i]=helper.get(i);
        }
         return ans;
    }
}