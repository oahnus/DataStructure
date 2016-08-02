package Find.QuickFind;

/**
 * Created by jackstrom on 2016/5/5.
 */
public class QF {
    private int[] id;

    QF(int num){
        id = new int[num];
        for(int i=0;i<num;i++){
            id[i] = i;
        }
    }

    boolean connected(int p,int q){
        return id[p]==id[q];
    }

    public void union(int p,int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0;i<id.length;i++){
            if(pid == id[p]){
                id[q] = pid;
            }
        }
    }

    public void print(){
        for(int i=0;i<id.length;i++){
            System.out.print(" "+id[i]);
        }
    }
}
