package Sort;

/**
 * Created by oahnus on 2016/8/12.
 */
public class BubbleSort {
    public static void sort(int[] src){
        int lastChange = src.length;
        int temp;
        while(lastChange!=0) {
            int length = lastChange;
            lastChange = 0;
            for (int i = 1; i < length; i++) {
                if (src[i] < src[i - 1]) {
                    temp = src[i - 1];
                    src[i - 1] = src[i];
                    src[i] = temp;
                    lastChange = i;
                }
            }
        }
    }
}
