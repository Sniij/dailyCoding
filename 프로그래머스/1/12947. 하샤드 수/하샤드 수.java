class Solution {
    public boolean solution(int x) {
        
        int len = Integer.parseInt(String.valueOf(x));
        int sum = 0, tmp = x;
        for(int i = 0; i < len; i++){
            sum += tmp % 10;
            tmp /= 10;
        }
        
        if( x%sum == 0 ) return true;
        else return false;
    }
}