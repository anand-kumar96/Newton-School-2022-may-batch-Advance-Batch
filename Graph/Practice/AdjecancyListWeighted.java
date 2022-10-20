package com.company.Newton_School.AdvanceDataStructure.Practice.Graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjecancyListWeighted {

    static ArrayList<ArrayList<Pair<Integer,Integer>>>AdjList=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        // now add n+1 arrayList in Adj list
        for(int i=0;i<n;i++){
            AdjList.add(new ArrayList<Pair<Integer,Integer>>());
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            AdjList.get(u).add(new Pair(v,wt));
            AdjList.get(v).add(new Pair(u,wt));
        }
        System.out.println(AdjList);
    }
}
/*
5 6
1 2 2
2 3 3
3 4 4
4 0 5
0 1 6
2 4 6
    0             1             2              3            4
[[4=5, 1=6], [2=2, 0=6], [1=2, 3=3, 4=6], [2=3, 4=4], [3=4, 0=5, 2=6]]


    (1)----2---(2)
     |          | -
     |          |   3
     6          6      -
     |          |        (3)
     |          |      -
     |          |   4
    (0)----5---(4) -

 */