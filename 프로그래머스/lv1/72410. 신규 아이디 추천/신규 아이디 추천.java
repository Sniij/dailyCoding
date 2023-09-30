class Solution {
    public static String solution(String new_id) {
        String answer = "";

        // 1단계 & 2단계 : 소문자 치환, 불필요한 문자 제거
        answer = new_id.toLowerCase().replaceAll("[^-_.a-z0-9]", "");

        // 3단계 : 마침표 2번 이상 -> 하나로
        answer = answer.replaceAll("[.]{2,}", ".");

        // 4단계 : 양끝의 마침표 제거
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5단계 : 빈 문자열이면 a 대입
       if (answer.equals("")) 
           answer += "a";

       // 6단계 : 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
       if (answer.length() >= 16) {
           answer = answer.substring(0,15);
           answer = answer.replaceAll("[.]$","");
       }

       //7단계: 길이가 짧으면 마지막 문자 반복해서 붙여주기 
       while(answer.length() <=2)
           if(answer.length()<3)
               answer +=answer.charAt(answer.length()-1);

       return answer;
    }
}