// method 01-->using merge interval concept
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]>list=new ArrayList<>();
          List<int[]>list1=new ArrayList<>();
        for(int []interval:intervals){
            list1.add(interval);
        }
        list1.add(newInterval);
        int intervalss[][]=list1.toArray(new int[list1.size()][2]);
        Arrays.sort(intervalss,(a,b)->Integer.compare(a[0],b[0]));
        for(int[] interval:intervalss){
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
}

// method 02
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]>list=new ArrayList<>();
        int idx=0;
        // step 1--> when we got insrertion position of new interval
        while(idx<intervals.length){
            if(intervals[idx][0]<newInterval[0]){
                list.add(intervals[idx]);
            }else{
                break;
            }
            idx++;
        }
        // step 2
        // suppose if list is empty then we add newinterval or no merging between interval and newinterval
        if(list.size()==0 || newInterval[0]>list.get(list.size()-1)[1]){
            list.add(newInterval);
        }else{
            // merging 
            int preinterval[]=list.get(list.size()-1);
            preinterval[1]=Math.max(preinterval[1],newInterval[1]);
        }
        
        // step 3 merging of remaing interval
        while(idx<intervals.length){
            int preinterval[]=list.get(list.size()-1);
            if(preinterval[1]>=intervals[idx][0]){
                preinterval[1]=Math.max(preinterval[1],intervals[idx][1]);
            }else{
                list.add(intervals[idx]);
            }
            idx++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}


// method -->with user input output
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertIntervals {
    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]>list=new ArrayList<>();
        int idx=0;
        // step 1--> when we got insrertion position of new interval
        while(idx<intervals.length){
            if(intervals[idx][0]<newInterval[0]){
                list.add(intervals[idx]);
            }else{
                break;
            }
            idx++;
        }
        // step 2
        // suppose if list is empty then we add newinterval or no merging between interval and newinterval
        if(list.size()==0 || newInterval[0]>list.get(list.size()-1)[1]){
            list.add(newInterval);
        }else{
            // merging
            int preinterval[]=list.get(list.size()-1);
            preinterval[1]=Math.max(preinterval[1],newInterval[1]);
        }

        // step 3 merging of remaing interval
        while(idx<intervals.length){
            int preinterval[]=list.get(list.size()-1);
            if(preinterval[1]>=intervals[idx][0]){
                preinterval[1]=Math.max(preinterval[1],intervals[idx][1]);
            }else{
                list.add(intervals[idx]);
            }
            idx++;
        }
        return list.toArray(new int[list.size()][2]);
    }
//    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
//        List<int[]> list=new ArrayList<>();
//        List<int[]>list1=new ArrayList<>();
//        for(int []interval:intervals){
//            list1.add(interval);
//        }
//        list1.add(newInterval);
//        int intervalss[][]=list1.toArray(new int[list1.size()][2]);
//        Arrays.sort(intervalss,(a,b)->Integer.compare(a[0],b[0]));
//        for(int[] interval:intervalss){
//            if(list.size()==0){
//                list.add(interval);
//            }else{
//                int preInterval[]=list.get(list.size()-1);
//                if(interval[0]<=preInterval[1]){
//                    preInterval[1]=Math.max(preInterval[1],interval[1]);
//                }else{
//                    list.add(interval);
//                }
//            }
//        }
//        return list.toArray(new int[list.size()][2]);
//    }
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
        int sp=sc.nextInt();
        int ep=sc.nextInt();
        int newInterval[]={sp,ep};
        // output Format
        int output[][]=insertIntervals(input,newInterval);
        System.out.print("[");
        for(int arr[]:output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}

/*
2
1 3
6 9
2 5
 */
