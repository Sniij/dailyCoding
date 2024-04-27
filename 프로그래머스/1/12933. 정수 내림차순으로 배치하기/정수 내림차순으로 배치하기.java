import java.util.*;

class Solution {
    public long solution(long n) {

        char[] numbers = String.valueOf(n).toCharArray();
        Arrays.sort(numbers);

        return Long.parseLong(new StringBuilder(new String(numbers)).reverse().toString());
    }
}