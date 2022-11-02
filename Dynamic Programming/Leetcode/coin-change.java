//https://leetcode.com/problems/coin-change/
// brute force -->tle
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
         int ans=Integer.MAX_VALUE;
      for(int i=0;i<coins.length;i++){
          if(amount>=coins[i]){
          int subAns=coinChange(coins,amount-coins[i]);
        if(subAns!=Integer.MAX_VALUE && subAns+1<ans){
                ans=subAns+1;
            }  
            }
            }
        
       if(ans==0 || ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
// dp solution
class Solution {
    public int coinChange(int[] coins, int amount) {
   if(amount==0) return 0;
    int[] dp = new int[amount+1];
    int sum = 0;
	while(++sum<=amount) {
		int min = -1;
    	for(int coin : coins) {
    		if(sum >= coin && dp[sum-coin]!=-1) {
    			int temp = dp[sum-coin]+1;
    			min = min<0 ? temp : (temp < min ? temp : min);
    		}
    	}
    	dp[sum] = min;
	}
	return dp[amount];
}
}
