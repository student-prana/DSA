class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(!isVowel(ch[left])){
                left++;

            }else if(!isVowel(ch[right])){
                right--;
            }
            else{
                char temp=ch[left];
                ch[left]=ch[right];
                ch[right]=temp;
                left++;
                right--;
            }
        }
        return String.valueOf(ch);
    }
    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u'||ch=='A'||ch=='E'||ch=='O'||ch=='U'||ch=='I'){
            return true;
        }else{
            return false;
        }
    }
}