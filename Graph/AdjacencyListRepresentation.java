package com.company.Newton_School.AdvanceDataStructure.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListRepresentation {
  static List<List<Integer>>AdjacencyList;
    AdjacencyListRepresentation(int N){
        AdjacencyList=new ArrayList<>();
        for(int i=0;i<N;i++){
            AdjacencyList.add(new ArrayList<>());
        }
    }
    public static boolean checkIfEdgeExists(int u,int v){
        if(AdjacencyList.get(u).contains(v)){
            return true;
        }
        return  false;
    }
    public  static void deleteEdge(Integer u,Integer v){
        // to delete given value if we remove int then it consider as index so we give object so it search for that value
        // it will autoboxing in int also so don't worry
        // so it will delete data not index
        AdjacencyList.get(u).remove(v);
        AdjacencyList.get(v).remove(u);
    }
     public  static void addEdge(int u,int v){
        AdjacencyList.get(u).add(v);
         AdjacencyList.get(v).add(u);
     }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=5;
        AdjacencyListRepresentation  adjacencyListRepresentation=new AdjacencyListRepresentation(N);
         adjacencyListRepresentation.addEdge(0,1);
         adjacencyListRepresentation.addEdge(0, 4);
         adjacencyListRepresentation.addEdge(1, 2);
         adjacencyListRepresentation.addEdge(1, 4);
         adjacencyListRepresentation.addEdge(2, 3);
        System.out.println(AdjacencyList);
        System.out.println( adjacencyListRepresentation.checkIfEdgeExists(1,3));
         adjacencyListRepresentation.deleteEdge(0,1);
        System.out.println(AdjacencyList);
        System.out.println( adjacencyListRepresentation.checkIfEdgeExists(0,1));


    }
}
