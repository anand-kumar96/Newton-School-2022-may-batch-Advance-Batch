package com.company.Newton_School.AdvanceDataStructure.Practice.Graph;
import java.util.Scanner;
public class AdjecancyMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        // inserting edges
        int matrix[][]=new int[n+1][m+1];
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            matrix[u][v]=1;
            matrix[v][u]=1;
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
// time com=O(N)
// space comp=O(N*N)