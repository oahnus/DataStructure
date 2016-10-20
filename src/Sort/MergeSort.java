package Sort;

/**
 * Created by oahnus on 2016/10/19.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] a = {2,3,8,1,4,7,6,9,5,10,11};
        sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }

    public static void sort(int[] src){
        divide(src,0,src.length-1);
    }

    private static void merge(int[] src, int start, int mid, int end){
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

    private static void divide(int[] src, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            divide(src,start,mid);
            divide(src,mid+1,end);
            merge(src,start,mid,end);
        }
    }
}
