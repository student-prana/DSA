class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
       int fre=0,ans=0;
       for(int i=0;i<n;i++){
        if(fre==0){
            ans=nums[i];
        }
        if(ans==nums[i]){
            fre++;
        }
        else{
            fre--;
        }
       }
       return ans;
    }
}