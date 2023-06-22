package programmers.level1.pass;

import java.util.ArrayList;
import java.util.Arrays;

public class P120956 {

    public void test() {

        String [] babbling1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String [] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println(solution(babbling1));
        System.out.println(solution(babbling2));
    }
    public int solution(String[] babbling) {

        String [] spoke = {"aya", "ye", "woo", "ma"};
        ArrayList<String> spokeList = new ArrayList<>(Arrays.asList(spoke));

        int answer = 0;
        for (String speak : babbling){


            for(String element: spokeList){
                if(speak.contains(element)){
                    speak = speak.replace(element, " ");

                }
            }
            speak = speak.replace(" ", "");

            if(speak.equals(""))
                answer++;
        }

        return answer;
    }
}
