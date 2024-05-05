class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 0){
            int tmp = s.length() / 2;
            answer = String.valueOf(s.charAt(tmp-1)).concat(String.valueOf(s.charAt(tmp)));
        }else{
            answer = String.valueOf(s.charAt(s.length()/2));
        }
        return answer;
    }
}