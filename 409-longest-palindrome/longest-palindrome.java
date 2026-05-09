class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int length=0;
        boolean odd=false;

        for(int count:map.values()){
            if(count%2==0){
                length+=count;
            }
            else{
                length+=count-1;
                odd=true;
            }
        }
        if(odd){
            length+=1;
        }
    
    return length;
    }
}