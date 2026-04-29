class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] result=new int[n+m];
        int k=0;
        for(int i=0;i<m;i++){
            result[k++]=nums1[i];
        }
        for(int i=0;i<n;i++){
            result[k++]=nums2[i];
        }
        Arrays.sort(result);
       for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        } 
        
    }
}