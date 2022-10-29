//https://leetcode.com/problems/candy/
// method 01
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arrLR[]=new int[n];
        int arrRL[]=new int[n];
        Arrays.fill(arrLR,1);
        Arrays.fill(arrRL,1);
        // from left to right
      for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]){
              arrLR[i]=arrLR[i-1]+1;
          }
      }
        // from right  to left
        for(int i=n-2;i>=0;i--){
          if(ratings[i]>ratings[i+1]){
              arrRL[i]=arrRL[i+1]+1;
          }
      }
        int totalCandy=0;
        // taking max between both
        
        for(int i=0;i<n;i++){
            totalCandy+=Math.max(arrLR[i],arrRL[i]);
        }
        return totalCandy;
    }
}
// method 02--> optimized
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arrLR[]=new int[n];
        int arrRL[]=new int[n];
        Arrays.fill(arrLR,1);
        Arrays.fill(arrRL,1);

       for(int i=1;i<n;i++){
          // from left to right
          if(ratings[i]>ratings[i-1]){
              arrLR[i]=arrLR[i-1]+1;
          }
          // from right  to left
          if(ratings[n-1-i]>ratings[n-i]){
              arrRL[n-1-i]=arrRL[n-i]+1;
          }
      }
        int totalCandy=0;
        // taking max between both
        for(int i=0;i<n;i++){
            totalCandy+=Math.max(arrLR[i],arrRL[i]);
        }
        return totalCandy;
    }
}
// method 03--> more optimize
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int candies[]=new int[n];
        Arrays.fill(candies,1);
       for(int i=1;i<n;i++){
          // from left to right
          if(ratings[i]>ratings[i-1]){
              candies[i]=candies[i-1]+1;
          }
       }
          // from right  to left
         int totalCandy=candies[n-1];
        
          for(int i=n-2;i>=0;i--){
          if(ratings[i]>ratings[i+1]){
               candies[i]=Math.max(candies[i],candies[i+1]+1);
           }
          totalCandy+=candies[i];
         }
        return totalCandy;
    }
}
