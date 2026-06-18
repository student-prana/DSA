class Solution {
    int bs(int [] nums,int target,int st,int end){
        if(st<=end){
            int mid=(st+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<=target){
                return bs(nums,target,mid+1,end);
    
            }
            else{
                return bs(nums,target,st,mid-1);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int st=0;
        int end=nums.length-1;
        return bs(nums,target,st,end);
    }
}