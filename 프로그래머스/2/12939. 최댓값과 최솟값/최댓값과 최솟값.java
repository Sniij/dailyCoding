class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int[] ansArr = new int[]{ Integer.parseInt(strArr[0]), Integer.parseInt(strArr[0])};
        
        for(String str: strArr){
            int strToInt = Integer.parseInt(str);
            ansArr[0] = Math.min(ansArr[0], strToInt);
            ansArr[1] = Math.max(ansArr[1], strToInt);
        }
        
        
        return String.valueOf(String.valueOf(ansArr[0])).concat(" ").concat(String.valueOf(ansArr[1]));
    }
}