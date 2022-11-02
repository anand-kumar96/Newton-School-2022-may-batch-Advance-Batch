//https://leetcode.com/problems/longest-common-subsequence/
// memorization method
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char string1arr[]=text1.toCharArray();
        char string2arr[]=text2.toCharArray();
        int string1length=string1arr.length;
        int string2length=string2arr.length;
        int lcaTable[][]=new int[string1length+1][string2length+1];
        for(int i=0;i<=string1length;i++){
            for(int j=0;j<=string2length;j++){
            if(i==0 || j==0){
            lcaTable[i][j]=0;
            }else if(string1arr[i-1]==string2arr[j-1]){ // since arr start from 0
            lcaTable[i][j]=lcaTable[i-1][j-1]+1; // don't confuse here we are taking lca table not char arr 

            }else{
            lcaTable[i][j]=Math.max(lcaTable[i-1][j],lcaTable[i][j-1]); // don't confuse
            }
           }
          }
         return lcaTable[string1length][string2length];
    }
}
/*
Tc:O(m*n)-->s1 length-->m s2 length-->n
*/


// mathod 01
class Solution {
public int longestCommonSubsequence(String text1, String text2) {
        char text1CharArr[] = text1.toCharArray();
        char text2CharArr[] = text2.toCharArray();

        int text1Length = text1CharArr.length;
        int text2Length = text2CharArr.length;

        int lcsTable[][] = new int[text1Length + 1][text2Length + 1];

        for(int i = 0; i <= text1Length; i++) {
            for(int j = 0; j <= text2Length; j++) {
                //not considering any character from one of the strings
                if(i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                }
                else if(text1CharArr[i - 1] == text2CharArr[j - 1]) {
                    lcsTable[i][j] = lcsTable[i - 1][j - 1] + 1;
                }
                else {
                    lcsTable[i][j] = Math.max(
                            lcsTable[i][j - 1],
                            lcsTable[i - 1][j]
                    );
                }
            }
        }

        return lcsTable[text1Length][text2Length];
    }
}
