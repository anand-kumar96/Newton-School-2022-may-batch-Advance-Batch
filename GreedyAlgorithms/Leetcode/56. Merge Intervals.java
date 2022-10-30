//https://leetcode.com/problems/merge-intervals/
//method 01
  class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int[] interval:intervals){
            if(list.size()==0){
                list.add(interval);
            }else{
                int preInterval[]=list.get(list.size()-1);
                if(interval[0]<=preInterval[1]){
                    preInterval[1]=Math.max(preInterval[1],interval[1]);
                }else{
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][0]);// or return list.toArray(new int[list.size()][]) --> autohandle colomn or--> give colmn size 2-->return list.toArray(new int[list.size()][2])
    }
}
