import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lIdx = 0, rIdx = people.length - 1;
        
        while(lIdx <= rIdx){
            if( people[lIdx] + people[rIdx] <= limit ){
                lIdx++;
            }
            rIdx--;
            answer++;
        }
        
        
        return answer;
    }
}