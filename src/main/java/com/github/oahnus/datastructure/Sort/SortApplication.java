package com.github.oahnus.datastructure.Sort;

import com.github.oahnus.datastructure.Sort.impl.HeapSort;
import com.github.oahnus.datastructure.Sort.impl.InsertSort;

import java.util.Arrays;

/**
 * Created by oahnus on 2016/8/12.
 */
public class SortApplication {
    public static void main(String[] args){
        // 堆排序
//        Sortable sortImpl = new HeapSort();
        // 插入排序
        Sortable sortImpl = new InsertSort();

        int[] data = DataUtil.genRandomDataArr(10);
        System.out.println("origin: " + Arrays.toString(data));
        sortImpl.sort(data);
        System.out.println("after: " + Arrays.toString(data));
    }
}
