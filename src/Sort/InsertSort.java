package Sort;


/**
 * Created by oahnus on 2016/8/12.
 */
public class InsertSort {
    public static void sort(int[] src){
        for(int i=1;i<src.length;i++){
            int temp = src[i];

            int j;

            for(j=i;j>0&&src[j-1]>temp;j--){
                src[j] = src[j-1];
            }
            src[j] = temp;
        }
    }
}
