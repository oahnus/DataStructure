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
        int i=start,j=end;
        while(i<j){
            while(i<j&&src[i]<=src[j])
                j--;
            if(i<j){
                int t = src[i];
                src[i] = src[j];
                src[j] = t;
                i++;
                for(int n=0;n<src.length;n++){
                    System.out.print(" "+src[n]);
                }
                System.out.println();
            }

            while(i<j&&src[i]<=src[j])
                i++;
            if(i<j){
                int t = src[i];
                src[i] = src[j];
                src[j] = t;
                j--;
                for(int n=0;n<src.length;n++){
                    System.out.print(" "+src[n]);
                }
                System.out.println();
            }
        }
        return i;
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
