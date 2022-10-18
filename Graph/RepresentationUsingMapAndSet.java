package com.company.Newton_School.AdvanceDataStructure.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class RepresentationUsingMapAndSet {
    static HashMap<Object,HashSet<Object>>graph;

    RepresentationUsingMapAndSet(){ // Can also give size
    graph=new HashMap<>();
    }

    public static boolean checkIfEdgeExists(Object u,Object v) {
        if(graph.containsKey(u)) {
            if(graph.get(u).contains(v)) {
                return  true;
            }
        }
        return false;
    }

    public static void deleteEdge(Object u,Object v){
        if(graph.containsKey(u)){
            if(graph.get(u).contains(v)) {
                graph.get(u).remove(v);
            }
        }
        if(graph.containsKey(v)){
            if(graph.get(v).contains(u)) {
                graph.get(v).remove(u);
            }
        }
    }

    public static void addEdge(Object u,Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u,new HashSet<>());
        }
        if(!graph.containsKey(v)) {
            graph.put(v,new HashSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    public static void main(String[] args) {

        RepresentationUsingMapAndSet representationUsingMapAndSet=new RepresentationUsingMapAndSet();
        representationUsingMapAndSet.addEdge(0,1);
        representationUsingMapAndSet.addEdge(0, 4);
        representationUsingMapAndSet.addEdge(1, 2);
        representationUsingMapAndSet.addEdge(1, 4);
        representationUsingMapAndSet.addEdge(2, 3);
        System.out.println(graph);
        /*
        System.out.println(graph);
        {0=[1, 4], 1=[0, 2, 4], 2=[1, 3], 3=[2], 4=[0, 1]}
         */
        System.out.println(representationUsingMapAndSet.checkIfEdgeExists(2,3));
        representationUsingMapAndSet.deleteEdge(1,4);
        System.out.println(graph);
        System.out.println(representationUsingMapAndSet.checkIfEdgeExists(5,3));
    }
}
