package Graph;

import java.util.Arrays;

/**
 * Created by oahnus on 2016/8/6.
 */
public class MGraph {
    public int[] vertex;
    public int[][] arc;

    /**
     * create a graph with vertexNum vertex
     * @param vertexNum
     */
    public MGraph(int vertexNum){
        vertex = new int[vertexNum];
        arc = new int[vertexNum][vertexNum];

        for(int i=0;i<arc.length;i++){
            Arrays.fill(arc[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<vertexNum;i++){
            vertex[i] = i;
        }
    }

    public void insertArc(int vertex1, int vertex2){
        arc[vertex1][vertex2] = 1;
        arc[vertex2][vertex1] = 1;
    }

    //if mgraph is network graph
    public void insertArc(int vertex1,int vertex2,int weight){
        arc[vertex1][vertex2] = weight;
        arc[vertex2][vertex1] = weight;
    }
}
