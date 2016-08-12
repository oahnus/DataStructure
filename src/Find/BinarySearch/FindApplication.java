package Find.BinarySearch;

import Find.BinarySearch.BinarySearch;

/**
 * Created by oahnus on 2016/8/12.
 */
public class FindApplication {
    public static void main(String[] args){
        int[] array = new int[]{2,5,15,23,56,67,87,100};
        int index = BinarySearch.find(array,0,array.length,87);

        if(index == -1){
            System.out.println("the array not contains the key");
        }else{
            System.out.println("the position of key in the array is:"+index);
        }
    }
}
