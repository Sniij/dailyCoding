import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        String tmp1 = String.valueOf(a)+String.valueOf(b);
        Integer tmp1ToInteger = Integer.parseInt(tmp1);
        int tmp2 = 2 * a * b;

        if( tmp1ToInteger > tmp2) answer = tmp1ToInteger;
        else answer = tmp2;
        
        return answer;
    }
}