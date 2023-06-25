package programmers.level1.pass;

public class P120830 {
    public void test(){

        System.out.println(solution(10,3));
        System.out.println(solution(64,6));

    }

    public int solution(int n, int k) {

        int answer = 0;
        answer = answer + (n * 12000);

        int nPercent = n / 10;

        k = k - nPercent;

        answer = answer + (k * 2000);


        return answer;
    }


}

