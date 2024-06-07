package programmers.level0.fail;

import java.util.*;

public class P72361 {
    class Solution {
        public int solution(String numbers) {
            int answer = 0;
            HashSet<Integer> hashset = new HashSet<Integer>();

            for(int i = 0; i < numbers.length(); i++) {
                String s = String.valueOf(numbers.charAt(i));
                int n = Integer.parseInt(s);
                hashset.add(n);
                for(int j = 0; j < numbers.length(); j++) {
                    String ss = String.valueOf(numbers.charAt(i)) +
                            String.valueOf(numbers.charAt(j));
                    int nn = Integer.parseInt(ss);
                    hashset.add(nn);
                    for(int k = 0; k < numbers.length(); k++) {
                        String sss = String.valueOf(numbers.charAt(i)) +
                                String.valueOf(numbers.charAt(j)) +
                                String.valueOf(numbers.charAt(k));
                        int nnn = Integer.parseInt(sss);
                        hashset.add(nnn);
                    }
                }
            }

            for(int n : hashset) {
                if(isPrime(n)) {
                    answer++;
                }
            }

            return answer;
        }

        public boolean isPrime(int num) {
            System.out.println(num);
            if(num == 0 || num == 1) return false;
            for(int i=2; i <= Math.sqrt(num); i++) {
                if(num%i==0)return false;
            }
            return true;
        }
    }
}
