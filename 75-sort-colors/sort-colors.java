class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }        
        int index=0;
        int zeroCount=map.getOrDefault(0,0);
        while(zeroCount-->0){
            nums[index++]=0;
        }
        int oneCount=map.getOrDefault(1,0);
        while(oneCount-->0){
            nums[index++]=1;
        }
        int twoCount=map.getOrDefault(2,0);
        while(twoCount-->0){
            nums[index++]=2;
        }
    }
}