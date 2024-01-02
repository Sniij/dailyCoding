import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        // 스코빌 지수가 K 보다 작으면 끝
        while (queue.peek() < K){
            // 모든 음식을 섞어도 K 이상 안되면 -1 리턴
            if( queue.size() == 1) return -1;

            int fir = queue.poll();
            int sec = queue.poll();
            
            int mix = fir + ( sec * 2 );
            queue.offer(mix);
            answer++;

        }


        return answer;
    }
}