import java.util.Arrays;

class Solution {
    public int makeTotalSum(){
        int first = 1;
        int last = 9;
        double half = (double) last / 2;
        return (int)((first  + last) * half);
    }
    public int solution(int[] numbers) {
        int answer = -1;
        //1. 0 ~9 까지 총합 구하기
        int sum = makeTotalSum();
        //2. 없는 숫자 총합 구하기
        int arraySum = Arrays.stream(numbers).sum();

        answer = sum - arraySum;

        return answer;
    }
}