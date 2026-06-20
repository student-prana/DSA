class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
        
    }

    private void solve(int i,int [] nums,List<Integer>curr,List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(nums[i]);
        solve(i+1,nums,curr,ans);


        curr.remove(curr.size()-1);
        while(i+1<nums.length&& nums[i]==nums[i+1]){
        i++;
        }
        solve(i+1,nums,curr,ans);
    }
}