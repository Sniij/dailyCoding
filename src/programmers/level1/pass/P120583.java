package programmers.level1.pass;

public class P120583 {

    public void test(){

        int[] array1 = {1, 1, 2, 3, 4, 5};
        int[] array2 = {0, 2, 3, 4};
        int n1 =1;
        int n2 =1;
        System.out.println(solution(array1,n1));
        System.out.println(solution(array2,n2));


    }

    public int solution(int[] array, int n) {
        int cnt =0;

        for(int el: array)
            if(el==n) cnt++;

        return cnt;
    }
}
