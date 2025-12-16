class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int lp=0,rp=n-1;
        int maxwater=0;
        while(lp<rp){
           int w=rp-lp;
            int ht=Math.min(height[lp],height[rp]);
            int water=w*ht;
            maxwater=Math.max(water,maxwater);

            if(height[lp] < height[rp]) 
             lp++ ;
             else
             rp--;
        }
        return maxwater;

    }
}