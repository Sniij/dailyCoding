class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++){
            int tmp = a[i] * b[i];
            answer += tmp;
        }
        
        return answer;
    }
}