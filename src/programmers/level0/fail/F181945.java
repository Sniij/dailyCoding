package programmers.level0.fail;

import java.util.Scanner;

public class F181945 {

    public void test(){
        solution();
    }
    public void solution()  {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (int i = 0; i <a.length(); i++) {
            System.out.println(a.charAt(i));
        }
    }
}
