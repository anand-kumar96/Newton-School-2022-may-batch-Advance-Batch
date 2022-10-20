package com.company.Newton_School.AdvanceDataStructure.Graph.Traversal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch {
    static HashMap<Object, HashSet<Object>> graph;
    DepthFirstSearch(){
        graph=new HashMap<>();
    }
    public  static void dfsTraversal(Object startingvertex){
        HashSet<Object>visitedVertex=new HashSet<>();
        Stack<Object> s=new Stack<>();
        s.add(startingvertex);
        while(!s.isEmpty()){
            Object currentVertex=s.pop();
            if(!visitedVertex.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visitedVertex.add(currentVertex);
            }
            HashSet<Object>neighbours=graph.get(currentVertex);
            for(Object eachNeighbour:neighbours){
                if(!visitedVertex.contains(eachNeighbour)){
                    s.push(eachNeighbour);
                }
            }
        }
        System.out.println();
    }

    public static void addEdge(Object u, Object v){
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
      DepthFirstSearch depthFirstSearch=new DepthFirstSearch();
        depthFirstSearch.addEdge(1,2);
        depthFirstSearch.addEdge(1,3);
        depthFirstSearch.addEdge(2,4);
        depthFirstSearch.addEdge(2,5);
        depthFirstSearch.addEdge(3,5);
        depthFirstSearch.addEdge(4,5);
        depthFirstSearch.addEdge(4,6);
        depthFirstSearch.addEdge(5,6);
        System.out.println(graph);
        depthFirstSearch.dfsTraversal(3);

        /*
        output:-
{1=[2, 3], 2=[1, 4, 5], 3=[1, 5], 4=[2, 5, 6], 5=[2, 3, 4, 6], 6=[4, 5]}
3 5 6 4 2 1
         */
        //  System.out.println(depthFirstSearch.graph);

//        depthFirstSearch.addEdge('a','b');
//        depthFirstSearch.addEdge('a','c');
//        depthFirstSearch.addEdge('b','d');
//        depthFirstSearch.addEdge('b','e');
//        depthFirstSearch.addEdge('c','e');
//        depthFirstSearch.addEdge('d','e');
//        depthFirstSearch.addEdge('d','f');
//        depthFirstSearch.addEdge('e','f');
//        System.out.println(graph);
//        depthFirstSearch.dfsTraversal('c');

/*
output:-
{a=[b, c], b=[a, d, e], c=[a, e], d=[b, e, f], e=[b, c, d, f], f=[d, e]}
c e f d b a
 */

    }
}
