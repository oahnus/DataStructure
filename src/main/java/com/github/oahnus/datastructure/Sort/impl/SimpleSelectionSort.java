package com.github.oahnus.datastructure.Sort.impl;

import com.github.oahnus.datastructure.Sort.Sortable;

/**
 * Created by oahnus on 2016/8/12.
 */
public class SimpleSelectionSort implements Sortable {
    public void sort(int[] src){
        for(int i=0;i<src.length;i++){
            int index = i;
            for(int j=i+1;j<src.length;j++){
                if(src[j]<src[index]){
                    index = j;
                }
            }
            if(index != i){
                int temp = src[i];
                src[i] = src[index];
                src[index] = temp;
            }
        }
    }
}
