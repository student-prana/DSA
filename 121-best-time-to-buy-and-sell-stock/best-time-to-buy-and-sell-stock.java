class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0,bestbuy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>bestbuy){
                maxprofit=Math.max(maxprofit,prices[i]-bestbuy);
            }
            bestbuy=Math.min(bestbuy,prices[i]);
        }
        return maxprofit;
    }
}