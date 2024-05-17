import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        // 토너먼트 대진표
        // 1. 1<->2, 3<->4, 5<->6, ... , N-1<->N 로 차례대로 배정
        // 2. 다음 라운드에서 다시 승자들에게 위에처럼 차례대로 배정
        // 한 명 남을 때가지 진행
        
        // A번을 가진 참가자와 B번을 가진 참가자가 서로 만나기 전까지 계속 이긴다면 언제 만나냐
        
        int answer = 0;

  
        while(a!=b){
            a = ( a + 1 ) / 2;
            b = ( b + 1 ) / 2;
            answer++;
        }
        

        


        return answer;
    }
}