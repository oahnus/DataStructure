package Find.BinarySearch;

/**
 * Created by oahnus on 2016/8/12.
 */
public class BinarySearch {
    /**
     *
     * @param a sorted array
     * @param k key
     * @return the index of key
     */
    public static int find(int[] a,int k){
        if(a == null){
            throw new RuntimeException("the array is null");
        }

        int start = 0;
        int end = a.length;

        int index = -1;

        while(start<end){
            int mid = (start+end)/2;
            if(a[mid] < k) start = mid;
            else if(a[mid] > k) end = mid-1;
            else{ index = mid;break;}
        }
        return index;
    }

    /**
     *
     * @param a sorted array
     * @param start 0
     * @param end array.length
     * @param k key
     * @return the index of key
     */
    public static int find(int[] a,int start,int end,int k){
        if(a == null){
            throw new RuntimeException("the array is null");
        }

        if(start >= end){
            return -1;
        }

        int mid = (start+end)/2;

        if(a[mid] < k) return find(a,mid,end,k);
        else if(a[mid] > k) return find(a,start,mid-1,k);
        else return mid;
    }
}
