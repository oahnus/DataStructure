package StringAndArray.BF;

/**
 * Created by jackstrom on 2016/4/26.
 */
public class BF {
    private String pattern;
    private String mainString;

    public BF(){
        mainString = " ";
        pattern = "";
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMainString() {
        return mainString;
    }

    public void setMainString(String mainString) {
        this.mainString = mainString;
    }

    public int matches(){
        char[] mainChars = mainString.toCharArray();
        char[] patternChars = pattern.toCharArray();

        for(int i=0;i<mainChars.length;i++){
            if(mainChars[i] == patternChars[0]){
                boolean isMatches = true;
                for(int j=0;j<patternChars.length;j++){
                    if(patternChars[j] != mainChars[i+j]){
                        isMatches = false;
                    }
                }
                if(isMatches){
                    return i;
                }
            }
        }
        return -1;
    }
}
