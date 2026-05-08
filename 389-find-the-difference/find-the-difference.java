class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            set.add(ch);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!set.contains(ch) || map.getOrDefault(ch,0)==0){
                return ch;
            }
            map.put(ch,map.get(ch)-1);
        }
            return ' ';
    }
}