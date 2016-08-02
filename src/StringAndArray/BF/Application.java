package StringAndArray.BF;

/**
 * Created by jackstrom on 2016/4/26.
 */
public class Application {
    public static void main(String[] args){
        BF bf = new BF();
        String main = "sdefabcfeasf";
        String p = "abc";
        bf.setMainString(main);
        bf.setPattern(p);

        int index = bf.matches();
        if(index!=-1){
            System.out.println("index:"+index+" "+main.substring(index,index+p.length()));
        }
    }
}
