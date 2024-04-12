package programmers.level0.fail;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class F1 {

    public int solution(int num) {
        int answer = 0;

        for (int i = num; ; i++){
            if(i%2 == 0){
                String numString = String.valueOf(i);
                int len = numString.length();
                int front = Integer.parseInt(numString.substring(0, len/2));
                int back = Integer.parseInt(numString.substring(len/2));
                if(calculate(front)==calculate(back)) return i;
            }
        }

    }

    private int calculate(int a) {
        int tmp = 1;
        while (a > 0) {
            tmp *= (a % 10);
            a /= 10;
        }
        return tmp;
    }

    public String solution(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            p1--; p2--;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public String solution(String vote) {
        String answer = "";

        int a = 0, b=0, c=0;

        int half = vote.length()/2;
        if(vote.length()%2 != 0) half++;

        for (char el: vote.toCharArray()){
            switch (el){
                case 'A': a++;
                        break;
                case 'B': b++;
                        break;
                case 'C': c++;
                        break;
                default: break;
            }
            if(c >= half) return "C";
            if(a >= half) return "A";
            if(b >= half) return "B";

        }
        if(a > b) answer = "A";
        else if (b > a) answer = "B";
        else if( a==b ) answer = "AB";

        return answer;
    }


    public String solution(String p, int n) {
        String answer = null;

        String[] split = p.split(" ");
        String[] time = split[1].split(":");

        int hr = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int sec = Integer.parseInt(time[2]);

        if (split[0].equals("PM") && hr != 12) {
            hr += 12;
        } else if (split[0].equals("AM") && hr == 12) {
            hr = 0;
        }

        LocalTime localTime = LocalTime.of(hr, min, sec);
        localTime = localTime.plusSeconds(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        answer = localTime.format(formatter);
        return answer;
    }



    public int[] solution(int[] grade) {
        int n = grade.length;
        int[] answer = new int[n];

        Integer[][] arr = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = grade[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);

        answer[arr[0][1]] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i][0].equals(arr[i-1][0])) {
                answer[arr[i][1]] = answer[arr[i-1][1]];
            } else {
                answer[arr[i][1]] = i+1;
            }
        }

        return answer;
    }
}

