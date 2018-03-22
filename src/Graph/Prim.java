package Graph;

/**
 * Created by oahnus on 2016/8/6.
 */

/**
 * use Prim algorithm to find minimal spanning tree
 */
public class Prim {
    //Auxiliary Array
    private Arc[] shortEdge;
    private MGraph mGraph;

    public Prim(MGraph mGraph){
        this.mGraph = mGraph;
        shortEdge = new Arc[mGraph.vertex.length];
        //init
        for(int i=0;i<shortEdge.length;i++){
            shortEdge[i] = new Arc();
            shortEdge[i].lowcost = this.mGraph.arc[0][i];
            shortEdge[i].adjvex = 0;
        }
    }

    public void findMST(){
        //vertex 0 input the auxiliary array
        shortEdge[0].lowcost = 0;

        for(int i=1;i<mGraph.vertex.length;i++){
            int k = minEdge(shortEdge, mGraph.vertex.length);
            System.out.print("("+k+",");
            System.out.print(shortEdge[k].adjvex+") ");
            System.out.print(shortEdge[k].lowcost+" ");

            shortEdge[k].lowcost = 0;
            for(int j=1;j<mGraph.vertex.length;j++){
                if(mGraph.arc[k][j] < shortEdge[j].lowcost){
                    shortEdge[j].lowcost = mGraph.arc[k][j];
                    shortEdge[j].adjvex = k;
                }
            }
            System.out.println();
        }
    }

    private int minEdge(Arc[] shortEdge, int length) {
        int minVertex = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            if(shortEdge[i].lowcost == 0) continue;
            if(shortEdge[i].lowcost<minCost){
                minVertex = i;
                minCost = shortEdge[i].lowcost;
            }
        }
        return minVertex;
    }

    class Arc{
        public int lowcost;
        public int adjvex;
    }

    public static void main(String[] args){
        MGraph mGraph = new MGraph(6);
        mGraph.insertArc(0,1,34);
        mGraph.insertArc(0,5,19);
        mGraph.insertArc(0,2,46);
        mGraph.insertArc(1,4,12);
        mGraph.insertArc(2,5,25);
        mGraph.insertArc(2,3,17);
        mGraph.insertArc(3,5,25);
        mGraph.insertArc(3,4,38);
        mGraph.insertArc(4,5,26);

        Prim prim = new Prim(mGraph);
        prim.findMST();
    }
}
