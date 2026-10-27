class Solution {
    public int maxVowels(String s, int k) {
        int count=0,max=0;
        for(int i=0;i<k;i++){
            char c=s.charAt(i);
            if("aeiou".indexOf(c)!=-1){
                count++;
            }
        }
        max=count;
        for(int i=k;i<s.length();i++){
            char in=s.charAt(i);
            char out=s.charAt(i-k);
            if("aeiou".indexOf(out)!=-1){
                count--;
            }
            if("aeiou".indexOf(in)!=-1){
                count++;
            }
            max=Math.max(count,max);
            if(max==k){
                return max;
            }
        }
        return max;
    }
}