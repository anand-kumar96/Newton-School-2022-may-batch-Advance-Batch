package com.company.Newton_School.AdvanceDataStructure.Practice.Graph;

import java.util.Scanner;
import java.util.ArrayList;
public class AdjecancyList {
    /*
    how to create list of an array
    ArrayList<Integer>arr[]=new ArrayList[n+1];
    means
    arr[0]={-----}
    arr[1]={------}
    |
    |
     */
   static ArrayList<ArrayList<Integer>>AdjList=new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        // now add n+1 arrayList in Adj list
        for(int i=0;i<n;i++){
            AdjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            AdjList.get(u).add(v);
            AdjList.get(v).add(u);
        }
        System.out.println(AdjList);
    }
}

// time comp=O(N
//space com=(2*Edge)

 /*
5 6
1 2
2 3
3 4
4 5
5 0
0 1
0 1 0 0 0 1 0
1 0 1 0 0 0 0
0 1 0 1 0 0 0
0 0 1 0 1 0 0
0 0 0 1 0 1 0
1 0 0 0 1 0 0


 */