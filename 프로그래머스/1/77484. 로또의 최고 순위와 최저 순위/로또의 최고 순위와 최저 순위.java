import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        List<Integer> lottoList = Arrays.stream(lottos).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> winList = Arrays.stream(win_nums).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));
        
        int winCnt = 0, lostCnt=0;
        for(int i = 0; i<winList.size(); i++){
            
            if( lottoList.get(i) == 0 ) {
                lostCnt++;
            }
            
            for(int j = 0; j<lottoList.size(); j++){
                if( winList.get(i) == lottoList.get(j) ){
                    winCnt++;
                    break;
                }   
            }
            
        }
        
        System.out.println(winCnt);
        System.out.println(lostCnt);
        
        int totalCnt = winCnt + lostCnt;
        
        if(winCnt<2) answer[1] = 6;
        else if(winCnt<3) answer[1] = 5;
        else if(winCnt<4) answer[1] = 4;
        else if(winCnt<5) answer[1] = 3;
        else if(winCnt<6) answer[1] = 2;
        else answer[1] = 1;
        
        if(totalCnt<2) answer[0] = 6;
        else if(totalCnt<3) answer[0] = 5;
        else if(totalCnt<4) answer[0] = 4;
        else if(totalCnt<5) answer[0] = 3;
        else if(totalCnt<6) answer[0] = 2;
        else answer[0] = 1;
        
        
        return answer;
    }
}