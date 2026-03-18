class Solution {
    public int compress(char[] chars) {
        String newstr="";
        for(int i=0;i<chars.length;i++){
            int count=1;
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            newstr+=chars[i];
            if(count>1){
                newstr+=count;
            }
        }
        for(int i=0;i<newstr.length();i++){
            chars[i]=newstr.charAt(i);
        }
        return newstr.length();
    }
}