import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> counts = new HashSet<>();

        for(int i = 0; i<numbers.length; i++){
            int a = numbers[i];
            for(int j = 0; j<numbers.length; j++){
                if(i != j){
                    counts.add(a+numbers[j]);
                }
            }
        }

        answer = new int[counts.size()];

        int index = 0;
        for(Integer tmp : counts){
            answer[index] = tmp;
            index++;
        }

        Arrays.sort(answer);

        return answer;
    }
}