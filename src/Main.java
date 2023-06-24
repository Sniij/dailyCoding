import programmers.level1.fail.F120907;
import programmers.level1.pass.*;
import programmers.level1.fail.F150370;
import programmers.level1.fail.F160586;

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
        p120583.test();


        // fail 목록
        F160586 f160586 = new F160586();
        //f160586.test();

        F150370 f150370 = new F150370();
        //f150370.test();

        F120907 f120907 = new F120907();
        f120907.test();

    }
}