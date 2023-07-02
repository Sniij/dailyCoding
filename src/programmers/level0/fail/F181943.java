package programmers.level0.fail;

import java.util.Scanner;

public class F181943 {

    public void test(){
        solution("He11oWor1d", "lloWorl", 2);
    }
    public String solution(String my_string, String overwrite_string, int s){
        StringBuilder answer = new StringBuilder();

        answer.append(my_string);
        answer.replace(s, s+overwrite_string.length(), overwrite_string);

        return answer.toString();
    }

}
