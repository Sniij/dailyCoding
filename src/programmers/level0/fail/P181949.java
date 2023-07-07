package programmers.level0.pass;

import java.util.Scanner;

public class P181949 {
    public void test(){
        solution();
    }
    public void solution()  {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i <a.length(); i++) {

            if (Character.isUpperCase(a.charAt(i))) {
                result.append(Character.toLowerCase(a.charAt(i)));
            } else if (Character.isLowerCase(a.charAt(i))) {
                result.append(Character.toUpperCase(a.charAt(i)));

            }
        }
        System.out.println(result.toString());
    }

}
