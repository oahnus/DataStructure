package com.github.oahnus.datastructure.Sort.impl;

import com.github.oahnus.datastructure.Sort.Sortable;

/**
 * Created by oahnus on 2019/7/29
 * 20:32.
 */
public class HeapSort implements Sortable {
    public void sort(int[] arr) {
        buildHeap(arr, arr.length-1);

        for (int sentry = arr.length - 1; sentry > 0; sentry--) {
            swap(arr, sentry, 0);
            buildHeap(arr, sentry - 1);
        }
    }

    private void swap(int[] arr, int aIdx, int bIdx) {
        int t = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = t;
    }

    /**
     * 构造大顶堆
     * @param arr 数据数组
     * @param buildSize 构造新堆的最大长度 buildSize <= arr.length
     */
    private void buildHeap(int[] arr, int buildSize) {
        int maxLeafIdx = buildSize / 2 - 1;
        for (int i = maxLeafIdx; i >= 0; i--) {
            if (arr[i] < arr[2*i+1]) {
                swap(arr, i, 2*i+1);
            }

            if (arr[i] < arr[2*i+2]) {
                swap(arr, i, 2*i+2);
            }
        }
    }
}
