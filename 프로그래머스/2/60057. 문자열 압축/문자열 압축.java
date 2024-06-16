import java.util.*;

class Solution {
    public int solution(String s) {

        int ans = 9999;

        for(int i=1; i<= s.length(); i++){
            StringBuilder sb = new StringBuilder(); 

            String pt = s.substring(0, i);

            for(int j=0; j<s.length(); j+=i){
                String ss = s.substring(j,Math.min(j+i, s.length()));

                if(sb.length()==0 || pt.equals(ss)==false){
                    sb.append(ss);
                    pt = ss;
                }

                else {
                    if(Character.isDigit(sb.charAt(sb.length()-1)) == false){
                        sb.append(2);
                    }
                    else {
                        StringBuilder sb2 = new StringBuilder();

                    for(int k = sb.length()-1; k>=0; k--){
                        if(Character.isDigit(sb.charAt(k))){
                            sb2.insert(0,sb.charAt(k));
                        } else break;
                    }
                        int oldNum = Integer.parseInt(sb2.toString());
                        oldNum++;

                        while(true){
                            char last = sb.charAt(sb.length()-1);
                            if(Character.isDigit(last)){
                                sb.deleteCharAt(sb.length()-1);
                            } else break;
                        }

                        sb.append(oldNum);
                    }
                }
            }

            ans = Math.min(ans, sb.length());

        }

        return Math.min(ans, s.length());
    }
}