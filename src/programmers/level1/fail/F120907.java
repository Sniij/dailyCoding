package programmers.level1.fail;

import java.util.Arrays;

public class F120907 {

    /*
    * 문제 설명
덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다. 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
    * */

    public void test(){

        String [] quiz1 = {"3 - 4 = -3", "5 + 6 = 11"};

        String [] quiz2 = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};

        System.out.println(Arrays.toString(solution(quiz1)));
        System.out.println(Arrays.toString(solution(quiz2)));

    }


    public String[] solution(String[] quiz) {



        for (String el: quiz) {

            for (int i = 0; i<el.length(); i++){
                String operator = "";
                int operand1 = 0;
                int operand2 = 0;
                if(el.charAt(i) == '-' || el.charAt(i) == '+'){
                    operator = String.valueOf(el.charAt(i));
                    if(i%2 == 1){
                        operand1 = Integer.parseInt(String.valueOf(el.charAt(i-2)));
                    }else {
                        operand1 = Integer.parseInt(String.valueOf(el.charAt(i-3)));
                        operand1 *= 10;
                        operand1 += Integer.parseInt(String.valueOf(el.charAt(i-2)));
                    }
                }
                System.out.println(operand1 + operator);
            }

        }

        String[] answer = {};
        return answer;
    }
}
