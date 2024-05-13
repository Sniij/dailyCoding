class Solution {
    public int solution(int n) {
        
        int[] fibonachi = new int[n+1];
        fibonachi[0] = 0; fibonachi[1] = 1; fibonachi[2] = 1;
        
        for(int i = 3; i < fibonachi.length; i++){
            fibonachi[i] = (fibonachi[i-1] + fibonachi[i-2]) % 1234567;
        }
        
        return fibonachi[n];
    }
    
}