class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum = 0, mul = 1;
        
        for(int el : num_list){
            sum += el;
            mul *= el;
        }
        sum = sum * sum;
        
        if(mul<sum) answer = 1;
        
        return answer;
    }
}