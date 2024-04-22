class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int cnt = 1;
        
        for(int i = 1; i <= n;){
            sum += i;
            //System.out.println("sum: "+sum + ", i: "+ i);

            if(sum == n) {
                answer++;
                sum = 0;
                cnt++;
                i = cnt;
            }else if(sum > n){
                sum = 0;
                cnt++;
                i = cnt;
            }else{
                i++;
            }
        }
    
        
        return answer;
    }
}