class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int minsum=Integer.MAX_VALUE;
        List<String> result=new ArrayList<>();
        

        for(int j=0;j<list2.length;j++){
            if(map.containsKey(list2[j])){
                int sum=j+map.get(list2[j]);
                if(sum<minsum){
                    minsum=sum;
                    result.clear();
                    result.add(list2[j]);
                }else if(sum==minsum){
                    result.add(list2[j]);
                }
            }
        }
        
        return result.toArray(new String[0]);
    }
}