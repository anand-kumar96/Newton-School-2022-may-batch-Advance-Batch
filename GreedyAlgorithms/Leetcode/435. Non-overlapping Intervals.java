//https://leetcode.com/problems/non-overlapping-intervals/
// method 01
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
        int count=0;
        int l=0;
        int r=1;
        while(r<n){
            if(intervals[l][1]<=intervals[r][0]){ // Non Overlapping case
                l=r;
                r++;
                }else if(intervals[l][1]<intervals[r][1]){ // Overlap case 1 (Remove Right Interval)
                count++;
                r++;
                }else{ // Overlap case 2 (Remove left Interval)
                count++;
                l=r;
                r++;
            }
        }
        return count;
    }
}

//method 02
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
   Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        int previousEnd = intervals[0][1];
        int deletedCount = 0;

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(previousEnd > currentStart) {
                previousEnd = Math.min(previousEnd, currentEnd);
                deletedCount++;
            }
            else {
                previousEnd = currentEnd;
            }
        }

        return deletedCount;
    }
}
