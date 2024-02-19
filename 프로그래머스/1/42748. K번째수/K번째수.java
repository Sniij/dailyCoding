import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    int cnt=0;
    int answer[]=new int[commands.length];

    for(int i=0;i<commands.length;i++){
    cnt=0;
    int[] arrs=new int[commands[i][1]-commands[i][0]+1];
       for(int j=commands[i][0]-1;j<commands[i][1];j++){
            arrs[cnt++]=array[j];
        }
    Arrays.sort(arrs);
    answer[i]=arrs[commands[i][2]-1];
    }

    return answer;
    }
}