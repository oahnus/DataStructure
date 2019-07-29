package com.github.oahnus.datastructure.Graph;

/**
 * Created by oahnus on 2016/8/3.
 */
public class BFSandDFS {

    public MGraph mGraph;

    public int[] visited = new int[]{0,0,0,0,0,0};

    public void createMGraph(){
        mGraph = new MGraph(6);
        mGraph.insertArc(0,1);
        mGraph.insertArc(0,2);
        mGraph.insertArc(1,3);
        mGraph.insertArc(1,4);
        mGraph.insertArc(3,5);
        mGraph.insertArc(4,5);
    }

    public void DFSTraverse(int v){
        System.out.print(mGraph.vertex[v]+"->");
        visited[v] = 1;
        for(int i=0;i<mGraph.vertex.length;i++){
            if(mGraph.arc[v][i]==1 && visited[i] == 0){
                DFSTraverse(i);
            }
        }
    }

    public void BFSTraverse(int v){
        int[] queue = new int[6];
        int front=-1,rear=-1;

        System.out.print(mGraph.vertex[v]+"->");
        visited[v] = 1;
        queue[++rear] = v;
        while(front!=rear){
            v = queue[++front];
            for(int j=0;j<mGraph.vertex.length;j++){
                if(mGraph.arc[v][j]==1&&visited[j]==0){
                    System.out.print(mGraph.vertex[j]+"->");
                    visited[j] = 1;
                    queue[++rear]=j;
                }
            }
        }
    }

    public void reset(){
        for(int i=0;i<visited.length;i++){
            visited[i] = 0;
        }
    }

    public static void main(String[] args){
        BFSandDFS bfSandDFS = new BFSandDFS();
        bfSandDFS.createMGraph();
        System.out.println("DFS");
        bfSandDFS.DFSTraverse(0);
        System.out.println();
        bfSandDFS.reset();
        System.out.println("BFS");
        bfSandDFS.BFSTraverse(0);
    }
}
