class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        ch=list(s)
        for i in range(0,len(ch),2*k):
            left=i
            right=min(i+k-1,len(ch)-1)
            while left<right:
                ch[left],ch[right]=ch[right],ch[left];
                left+=1
                right-=1
        return ''.join(ch)