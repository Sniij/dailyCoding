import java.util.*;


class Solution {
    
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    
    private static int dfs(int[] numbers, int target, int sum, int current) {
        int ans = 0;

        if (current == numbers.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        ans += dfs(numbers, target, sum + numbers[current], current + 1);
        ans += dfs(numbers, target, sum + numbers[current] * -1, current + 1);

        return ans;
    }

    private static class Pair {
        int position;
        int sum;

        public Pair(int position, int sum) {
            this.position = position;
            this.sum = sum;
        }
    }
}