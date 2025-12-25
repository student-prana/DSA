class Solution {
    public void nextPermutation(int[] nums) {
        int pivot =-1;
        int temp;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            int i=0,j=n-1;
            while (i < j) {
                 temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
        }
            return ;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[pivot]){
                temp=nums[i];
                nums[i]=nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }
        int i=pivot+1,j=n-1;
        while(i<j){
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        
    }
}