import programmers.level1.pass.P120830;
import programmers.level1.fail.F120907;
import programmers.level1.pass.*;
import programmers.level1.fail.F150370;
import programmers.level1.fail.P160586;

public class Main {
    public static void main(String[] args) {


        // pass 목록
        P178871 p178871 = new P178871();
        //p178871.test();
        P176963 p176963 = new P176963();
        //p176963.test();
        P172928 p172928 = new P172928();
        //p172928.test();
        P161990 p161990 = new P161990();
        //p161990.test();

        P161989 p161989 = new P161989();
        //p161989.test();

        P120956 p120956 = new P120956();
        //p120956.test();

        P120583 p120583 = new P120583();
        //p120583.test();

        P120830 p120830 = new P120830();
        //p120830.test();

        // fail 목록
        P160586 p160586 = new P160586();
        //p160586.test();

        F150370 f150370 = new F150370();
        //f150370.test();

        F120907 f120907 = new F120907();
       // f120907.test();

        System.out.println(solution(new int[] {1, 3, 4, 6}));
        System.out.println(solution(new int[] {1, 7, 1, 2}));

    }



    public static String solution(int[] food) {

        StringBuilder answer = new StringBuilder();
        int order = -1;
        for (int el: food) {
            order++;

            if(el>=2){
                int tmp = el/2;
                String tmp2 = String.valueOf(order).repeat(tmp);
                answer.append(tmp2);
            }

        }
        StringBuilder reverse = new StringBuilder(answer.reverse().toString());
        answer.reverse();
        answer.append("0");
        answer.append(reverse);

        return answer.toString();
    }
}