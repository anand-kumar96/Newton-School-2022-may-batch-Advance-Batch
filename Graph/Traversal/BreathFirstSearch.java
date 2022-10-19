package com.company.Newton_School.AdvanceDataStructure.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
    /*
   static  HashMap<Object, HashSet<Object>>graph=new HashMap<>(); ;; // declare in custom class
    // without constructor also can do
     */
    static  HashMap<Object, HashSet<Object>>graph;
    BreathFirstSearch(){
    graph=new HashMap<>(); // initialize
    }
   public static void bfsTraversal(Object startingVertex){
        HashSet<Object>visitedSet=new HashSet<>();
        visitedSet.add(startingVertex);
       Queue<Object>q=new LinkedList<>();
       q.add(startingVertex);
       while(!q.isEmpty()){
           Object currentVertex=q.poll();
           System.out.print(currentVertex+" ");
           HashSet<Object>neighbours=graph.get(currentVertex);
           for(Object eachVertex:neighbours){
               if(!visitedSet.contains(eachVertex)){
                   visitedSet.add(eachVertex);
                   q.add(eachVertex);
               }
           }
       }
       System.out.println();
   }


    public static void  addEdge(Object u,Object v){
        if(!graph.containsKey(u)){
            graph.put(u,new HashSet<>());
        }
        if(!graph.containsKey(v)){
            graph.put(v,new HashSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
        BreathFirstSearch breathFirstSearch=new BreathFirstSearch();
        breathFirstSearch.addEdge(1,2);
        breathFirstSearch.addEdge(1,3);
        breathFirstSearch.addEdge(2,4);
        breathFirstSearch.addEdge(2,5);
        breathFirstSearch.addEdge(3,5);
        breathFirstSearch.addEdge(4,5);
        breathFirstSearch.addEdge(4,6);
        breathFirstSearch.addEdge(5,6);
        System.out.println(graph);
        breathFirstSearch.bfsTraversal(5);
    }
}

// tc=N(n-1)
//ts= O(N^2)
// for add edge-->ts=O(N)