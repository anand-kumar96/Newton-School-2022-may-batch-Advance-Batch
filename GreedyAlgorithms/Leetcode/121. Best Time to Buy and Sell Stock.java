// brute force --> tle
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n-1;j++){
              profit=Math.max(profit,(prices[j+1]-prices[i]));
            }
        }
        return profit;
    }
}
// optimized way--> by me
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int n=prices.length;
        int i=1;
        int j=0;
        while(i<n){
            if(prices[j]>prices[i]){
                j=i;
                i++;
            }else{
             profit=Math.max(profit,(prices[i]-prices[j]));
              i++;
        }
        }
        return profit;
    }
}
// method 02
class Solution {
      public int maxProfit(int[] prices) {
       int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){ // if we found new buy value which is more smaller then previous one
                lsf = prices[i]; // update our least so far
            }
            pist = prices[i] - lsf; // calculating profit if sold today by, Buy - sell
            if(op < pist){ // if pist is more then our previous overall profit
                op = pist; // update overall profit
        }
        }
        return op; // return op 
}
}
