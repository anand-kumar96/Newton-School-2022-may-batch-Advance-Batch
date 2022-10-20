package com.company.Newton_School.AdvanceDataStructure.Practice.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjeacancydirectedGraph {
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
        }
        System.out.println(AdjList);
    }
}
/*
6 8
1 2
2 3
3 4
4 5
5 0
0 1
1 5
5 3
[[1], [2, 5], [3], [4], [5], [0, 3]]
 */