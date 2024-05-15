import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        StringBuffer strbff = new StringBuffer();
        for(char el: s.toCharArray()){
            if(strbff.length()!=0){
                if(strbff.charAt(strbff.length()-1) == el) {
                    strbff.deleteCharAt(strbff.length()-1);
                    continue;
                }
            }
            strbff.append(String.valueOf(el));
        }
        
        if(strbff.length()==0) return 1;
        return 0;
    }
}