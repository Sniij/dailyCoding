package programmers.level0.pass;

import java.util.Scanner;

public class P181950 {
    public void test(){
        solution();
    }
    public void solution()  {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
}
