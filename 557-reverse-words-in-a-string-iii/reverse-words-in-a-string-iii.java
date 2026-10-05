class Solution {
    public String reverseWords(String s) {
        char ch[]=s.toCharArray();
        int left=0;
        for(int i=0;i<=ch.length;i++){
            if(i==ch.length || ch[i]==' '){
                int right=i-1;
                while(left<right){
                    char temp=ch[left];
                    ch[left]=ch[right];
                    ch[right]=temp;
                    left++;
                    right--;
                }
                left=i+1;
            }
        }
        return new String(ch);
    }
}