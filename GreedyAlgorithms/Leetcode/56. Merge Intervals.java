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

// with Iput format
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class MergeInterval {
    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
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
        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // input format
        int n=sc.nextInt();
        int input[][]=new int[n][2];
        for(int i=0;i<n;i++){
            int sp=sc.nextInt();
            int ep=sc.nextInt();
            input[i][0]=sp;
            input[i][1]=ep;
        }
        // output Format
        int output[][]=mergeIntervals(input);
        System.out.print("[");
        for(int arr[]:output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}
//https://www.youtube.com/watch?v=_FkR5zMwHQ0&t=335s
