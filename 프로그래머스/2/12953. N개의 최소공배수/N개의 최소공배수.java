import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int big = arr[arr.length-1];
        int index = arr.length-1;
        while(true)
        {
            boolean check = true;

            for(int i=0; i<index; i++)
            {
                if(big%arr[i]!=0)
                {
                    check = false;
                }
                else
                {

                }
            }
            if(check==true)
            {
                answer = big;
                break;
            }
            big = big+arr[arr.length-1];
        }
        return answer;
    }
}