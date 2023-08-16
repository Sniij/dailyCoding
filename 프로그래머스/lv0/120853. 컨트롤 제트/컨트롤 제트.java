class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] strings = s.split(" ");
        for(int i =0; i<strings.length; i++){
        //System.out.println(strings[i]);

            if(strings[i].equals("Z")){
                answer -= Integer.parseInt(strings[i-1]);
            }else{
                answer += Integer.parseInt(strings[i]);
            }

        }
        
        
        return answer;
    }
}