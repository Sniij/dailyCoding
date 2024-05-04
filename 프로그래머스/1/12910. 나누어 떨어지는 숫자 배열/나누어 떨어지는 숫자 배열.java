import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        
        for(int el: arr){
            if(el%divisor == 0) answer.add(el);
        }
             
        Collections.sort(answer);
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(el->el).toArray();
    }
}