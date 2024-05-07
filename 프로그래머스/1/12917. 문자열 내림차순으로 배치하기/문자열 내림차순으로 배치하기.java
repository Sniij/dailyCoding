import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(int i = chars.length-1; i >= 0; i--){
            char el = chars[i];
            if('a' <= el && el <= 'z')
                lower.append(el);
            else
                upper.append(el);
        }
        
        return lower.toString().concat(upper.toString());
    }
}