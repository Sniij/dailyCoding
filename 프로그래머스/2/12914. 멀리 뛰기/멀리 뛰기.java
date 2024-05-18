class Solution {
    public long solution(int n) {
        long[] cnt = new long[2001];
        cnt[1] = 1;
        cnt[2] = 2;
        
        for(int i = 3; i <= n; i++){
            cnt[i] = (cnt[i-1] + cnt[i-2]) % 1234567;
        }
        
        return cnt[n];
    }
}