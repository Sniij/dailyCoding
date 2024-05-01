class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0, yCnt = 0;
        s = s.toLowerCase();
        for(char el: s.toCharArray()){
            if(el == 'p') pCnt++;
            else if(el == 'y') yCnt++;
        }
        
        if(pCnt == yCnt) return true;
        else return false;
        }
}