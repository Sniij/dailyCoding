import java.util.*;

public class Solution {
    public int solution(int n) {
        int amount_of_use = 0;
        while (n > 0){
            if (n % 2 == 0){
                n /= 2;
            }
            else{
                n--;
                amount_of_use++;
                }
            }
        return amount_of_use;
    }
}
