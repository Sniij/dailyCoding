import java.util.*;


class Solution {
    static class Stage implements Comparable<Stage> {
        int num;
        double failRate;

        public Stage(int num, double failRate) {
            this.num = num;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failRate < o.failRate) {
                return 1;
            } else if (this.failRate > o.failRate) {
                return -1;
            } else {
                return this.num - o.num;
            }
        }
    }

    public static int[] solution(int N, int[] stages) {
        Stage[] stageArr = new Stage[N];
        int total = stages.length;
        
        for(int i = 1; i <= N; i++){
            int count = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i){
                    count++;
                }
            }
            double failRate = (total == 0) ? 0 : (double)count / total;
            total -= count;
            
            stageArr[i-1] = new Stage(i, failRate);
        }
        
        Arrays.sort(stageArr);
        
        int[] answer = new int[N];
        for(int i = 0; i < stageArr.length; i++){
            answer[i] = stageArr[i].num;
        }
        
        return answer;
    }
}