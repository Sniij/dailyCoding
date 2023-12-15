import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            queue.add((100-progresses[i]) % speeds[i] > 0 ? (100-progresses[i]) / speeds[i] + 1 : (100-progresses[i]) / speeds[i]);
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        int preWorkDay = queue.poll();
        int numOfSameWorkDay = 1;
        while(!queue.isEmpty()) {
            int workDay = queue.poll();
            if(preWorkDay >= workDay) {
                numOfSameWorkDay++;
            } else {
                answerList.add(numOfSameWorkDay);
                numOfSameWorkDay = 1;
                preWorkDay = workDay;
            }
        }
        answerList.add(numOfSameWorkDay);
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}