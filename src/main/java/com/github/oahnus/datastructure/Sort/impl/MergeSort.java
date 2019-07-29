package com.github.oahnus.datastructure.Sort.impl;

import com.github.oahnus.datastructure.Sort.Sortable;

/**
 * Created by oahnus on 2016/10/19.
 */
public class MergeSort implements Sortable {
    public void sort(int[] src){
        divide(src,0,src.length-1);
    }

    private void merge(int[] src, int start, int mid, int end){
        int i=start,j=mid+1;
        int m = mid,n=end;
        int k=0;

        int[] temp = new int[end-start+1];

        while(i<=m&&j<=n){
            if(src[i]<=src[j]){
                temp[k++] = src[i++];
            }else{
                temp[k++] = src[j++];
            }
        }
        while(i<=m){
            temp[k++] = src[i++];
        }
        while(j<=n){
            temp[k++] = src[j++];
        }
        for(i=0;i<k;i++){
            src[start+i] = temp[i];
        }
    }

    private void divide(int[] src, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            divide(src,start,mid);
            divide(src,mid+1,end);
            merge(src,start,mid,end);
        }
    }
}
