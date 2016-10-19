package Sort;

/**
 * Created by oahnus on 2016/8/12.
 */
public class Sort_Application {
    public static void main(String[] args){
        int[] a = new int[]{10,3,6,5,2,1,9,7,8,4};

//        BubbleSort.sort(a);
//        SimpleSelectionSort.sort(a);
        InsertSort.sort(a);

        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }
}
