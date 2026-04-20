class Solution {
    public int maxSubArray(int[] nums) {
         int ms=Integer.MIN_VALUE;;
         int cs=0;
         for(int i=0;i<nums.length;i++){
            cs=Math.max(nums[i],cs+nums[i]);
            ms=Math.max(cs,ms);
         }
        return ms;
    }
}