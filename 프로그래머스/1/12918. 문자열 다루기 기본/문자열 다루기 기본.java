class Solution {
    public boolean solution(String s) {

        int sLength = s.length();

        if (sLength == 4 || sLength == 6){
            for(char c : s.toCharArray()){
                if(c < '0' || c > '9')
                    return false;
            }
            return true;
        }
        return false;
    }
}