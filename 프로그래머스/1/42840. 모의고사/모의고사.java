import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int user1[]={1,2,3,4,5};
        int user2[]={2,1,2,3,2,4,2,5};
        int user3[]={3,3,1,1,2,2,4,4,5,5};
        int cnt[]={0,0,0};
        int score[]={0,0,0};
        int max=0;
        int result_cnt=0;

        for(int i=0;i<answers.length;i++){
            if( user1[cnt[0]++]==answers[i])
                score[0]+=1;
            if( user2[cnt[1]++]==answers[i])
                score[1]+=1;
            if( user3[cnt[2]++]==answers[i])
                score[2]+=1;

            if(cnt[0]>=user1.length)
                cnt[0]=0;
            if(cnt[1]>=user2.length)
                cnt[1]=0;
            if(cnt[2]>=user3.length)
                cnt[2]=0;
        }

        for(int i=0;i<3;i++){
            if( score[i]>=max )
                max=score[i];
        }

        for(int i=0;i<3;i++){
            if( score[i]==max )
                result_cnt+=1;
        }

        int answer[] = new int[result_cnt];

        result_cnt=0;
        for(int i=0;i<3;i++){
            if( score[i]==max )
            answer[result_cnt++]=i+1;
        }
return answer;
    }
}