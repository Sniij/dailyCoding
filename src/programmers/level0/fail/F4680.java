package programmers.level0.fail;

public class F4680 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int i = 3;
            int ans_n_minus_2 = 1;
            int ans_n_minus_1 = 2;

            while (i < n) {
                answer = (ans_n_minus_2 + ans_n_minus_1) % 1000000007;
                ans_n_minus_2 = ans_n_minus_1;
                ans_n_minus_1 = answer;
                i++;
            }
            answer = (ans_n_minus_2 + ans_n_minus_1) % 1000000007;
            return answer;
        }



        /**
         * 재귀로 했더니 시간초과/런타임 에러 남..
         * 재귀 함수
         * n = 1 -> 1 (세로 한 가지)
         * n = 2 -> 2 (가로, 세로 두 가지)
         * n = 3 -> 3 (첫 번째 가로 -> n = 1 일때, 첫 번째 세로 -> n = 2 일때)
         * n = 4 -> 5 (n = 2 + n = 3)
         * n = sub_solution(n - 2) + sub_solution(n - 1)
         */
        public int sub_solution(int n) {
            if (n <= 2)
                return n;
            return (sub_solution(n - 1) + sub_solution(n - 2)) % 1000000007;
        }
    }

}
