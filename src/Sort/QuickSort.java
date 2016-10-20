package Sort;

/**
 * Created by jackstrom on 2016/5/8.
 */
public class QuickSort {
    private int[] source;

    public int[] sort(int[] src){
        this.source = src;

        quickSort(source,0,source.length-1);

        return source;
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

    public static void main(String[] args){
        int[] src = new int[]{5,3,4,1,2,7,9,8,6,10};
        QuickSort qs = new QuickSort();
        int[] retVal = qs.sort(src);
        for(int i=0;i<retVal.length;i++){
            System.out.print(" "+retVal[i]);
        }
    }
}
