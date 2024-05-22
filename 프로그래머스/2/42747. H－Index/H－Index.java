class Solution {
    public int solution(int[] citations) {
        int[] inDragon = new int[10001];
        
        for(int num : citations ) 
            inDragon[num]++;
        
        int n = citations.length;
        int answer = 0;
        for(int h = 1; h <= 10000; h++){
            n -= inDragon[h-1];
            if(n >= h) 
                answer = h;
            else break;
        }
        return answer;
    }
}