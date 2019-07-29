package com.github.oahnus.datastructure.Sort.impl;

import com.github.oahnus.datastructure.Sort.Sortable;

/**
 * Created by jackstrom on 2016/5/8.
 */
public class QuickSort implements Sortable {
    public void sort(int[] src){
        quickSort(src,0,src.length-1);
    }

    private void quickSort(int[] src,int start,int end){
        if(start<end){
            int mid = part(src,start,end);
            quickSort(src,start,mid-1);
            quickSort(src,mid+1,end);
        }
    }

    private int part(int[] src,int start,int end){
        int left=start,right=end;
        while(left<right){
            while(left<right&&src[left]<=src[right])
                right--;
            if(left<right){
                int t = src[left];
                src[left] = src[right];
                src[right] = t;
                left++;
            }

            while(left<right&&src[left]<=src[right])
                left++;
            if(left<right){
                int t = src[left];
                src[left] = src[right];
                src[right] = t;
                right--;
            }
        }
        return left;
    }
}
