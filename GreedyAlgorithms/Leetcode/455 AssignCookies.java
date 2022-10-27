//https://leetcode.com/problems/assign-cookies/
// method 03
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a=g.length;
        int b=s.length;
        int i=0,j=0;
        int count=0;
        while(i<a && j<b){
            if(s[j]>=g[i]){
                count++;
                i++;
                j++;
            }else{
              j++;  
            }
            
        }
        return count;
    }
}
// method 02
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int happychild=0;
        for(int i=0;happychild<g.length && i<s.length;i++){
            if(s[i]>=g[happychild]){
                happychild++;
            }
        }
        return happychild;
    }
}

// or
 public int findContentChildren(int[] g, int[] s) {
        int greedFactor[] = g;
        int cookieSize[] = s;

        Arrays.sort(greedFactor);
        Arrays.sort(cookieSize);

        int happyChild = 0;
        for(int cookieIndex = 0; happyChild < greedFactor.length && cookieIndex < cookieSize.length; cookieIndex++) {
            if(cookieSize[cookieIndex] >= greedFactor[happyChild]) {
                happyChild++;
            }
        }

        return happyChild;
    }
