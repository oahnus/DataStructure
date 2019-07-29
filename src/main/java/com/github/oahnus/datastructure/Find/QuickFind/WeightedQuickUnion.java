package com.github.oahnus.datastructure.Find.QuickFind;

/**
 * Created by jackstrom on 2016/5/5.
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;//count the number of objects in the tree rooted i;

    WeightedQuickUnion(int num){
        id = new int[num];
        sz = new int[num];
        for(int i=0;i<num;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }

        return i;
    }

    public void union(int p,int q){
        int proot = root(p);
        int qroot = root(q);
        if(proot == qroot) return;
        if(sz[proot]<sz[qroot]){
            id[proot] = qroot;
            sz[qroot] += sz[proot];
        }
        else {
            id[qroot] = proot;
            sz[proot] += sz[qroot];
        }
    }

    public boolean connected(int p,int q){
        return root(p) == root(q);
    }

    public void print(){
        for(int i=0;i<id.length;i++){
            System.out.print(" "+id[i]);
        }
    }

    public void printsz(){
        for(int i=0;i<id.length;i++){
            System.out.print(" "+sz[i]);
        }
    }
}
