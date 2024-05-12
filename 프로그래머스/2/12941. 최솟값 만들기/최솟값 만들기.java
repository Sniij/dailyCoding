import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int length = B.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = B[i];
            B[i] = B[length - i - 1];
            B[length - i - 1] = temp;
        }
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        
        return answer;
    }
}