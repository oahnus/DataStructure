package Find.QuickFind;

/**
 * Created by jackstrom on 2016/5/5.
 */
public class QuickUnion {
    private int[] id;

    QuickUnion(int num){
        id = new int[num];
        for(int i=0;i<num;i++) id[i] = i;
    }

    private int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p,int q){
        return root(p) == root(q);
    }

    public void union(int p,int q){
        int proot = root(p);
        int qroot = root(q);
        id[proot] = qroot;
    }

    public void print(){
        for(int i=0;i<id.length;i++){
            System.out.print(" "+id[i]);
        }
    }
}
