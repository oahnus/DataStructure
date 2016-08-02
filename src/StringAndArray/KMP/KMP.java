package StringAndArray.KMP;

import java.util.ArrayList;

/**
 * Created by jackstrom on 2016/4/27.
 */
public class KMP {
    public KMP(){

    }

    public int[] getNextArray(String pattern){
        char[] patternChars = pattern.toCharArray();
        int[] next = new int[pattern.length()];
        int k=-1,j=0;
        next[0] = -1;

        while(j!=patternChars.length-1){
            if((k==-1)||patternChars[k] == patternChars[j]){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }

        return next;
    }

    public int matches(String template,int[] next,String pattern){
        int index = -1;
        int i=0,j=0;

        char[] tempChars = template.toCharArray();
        char[] patternChars = pattern.toCharArray();
        while(i<tempChars.length&&j<next.length){
            if(tempChars[i] == patternChars[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
            if(j == -1){
                i++;
                j++;
            }
        }
        index = i-patternChars.length;
        return index;
    }

    public static void main(String[] args){
        KMP kmp = new KMP();
        String temp = "abdsabsdabdabcsdabbas";
        String pattern = "dabdabcs";
        int[] next = kmp.getNextArray(pattern);

        System.out.print("Next:");
        for(int i=0;i<next.length;i++){
            System.out.print(next[i] + " ");
        }

        int index = kmp.matches(temp,next,pattern);

        System.out.println("index:"+index+" "+temp.substring(index,index+pattern.length()));

        ArrayList a = new ArrayList();
        a.toArray();
    }
}
