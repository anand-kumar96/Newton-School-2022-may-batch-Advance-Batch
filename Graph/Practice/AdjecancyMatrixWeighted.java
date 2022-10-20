package com.company.Newton_School.AdvanceDataStructure.Practice.Graph;

import java.util.Scanner;

public class AdjecancyMatrixWeighted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        // inserting edges
        int matrix[][]=new int[n+1][m+1];
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            matrix[u][v]=wt;
            matrix[v][u]=wt;
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
/*
// 0 index based
5 6
1 2 2
2 3 3
3 4 4
4 0 5
0 1 6
2 4 6
0 0 0 0 0 0 0
0 0 2 0 0 6 0
0 2 0 3 6 0 0
0 0 3 0 4 0 0
0 0 6 4 0 5 0
0 6 0 0 5 0 0
 */