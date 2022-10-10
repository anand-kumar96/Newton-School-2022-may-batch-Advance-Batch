//https://leetcode.com/problems/assign-cookies/
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
