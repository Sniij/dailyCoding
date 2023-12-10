class Solution {
    public long solution(long n) {
        long i = 0;
        while(i*i<=n)
            if(++i*i == n) return n+2*i+1;
        return -1;
    }
}