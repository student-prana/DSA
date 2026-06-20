class Solution {
    private void solve(int index,int [] nums,List<List<Integer>> ans){
        if(index==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        HashSet<Integer> used=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);


            swap(nums,index,i);
            solve(index+1,nums,ans);
            swap(nums,index,i);

        }
    }

    private void swap(int [] nums ,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
}