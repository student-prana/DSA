class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;
         if (m == 0) {
            for (i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
          while (i < m) {
            result[k++] = nums1[i++];
        }

        while (j < n) {
            result[k++] = nums2[j++];
        }

        for(i=0;i<m+n;i++){
            nums1[i]=result[i];
                    }
        
    }
}