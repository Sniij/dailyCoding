import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;
        int sumWeight = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck_weights[i]);
                    sumWeight += truck_weights[i];
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    sumWeight -= bridge.poll();
                } else {
                    if (sumWeight + truck_weights[i] > weight) {
                        bridge.offer(0);
                        answer++;
                    } else {
                        bridge.offer(truck_weights[i]);
                        sumWeight += truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}