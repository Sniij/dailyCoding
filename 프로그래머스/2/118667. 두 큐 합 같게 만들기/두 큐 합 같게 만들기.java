import java.util.*;
class Solution {
    // 접근 알고리즘 개념 - 그리디 
    // 탐욕 알고리즘은 최적해를 구하는 데에 사용되는 근사적인 방법으로, 
    // 여러 경우 중 하나를 결정해야 할 때마다 그 순간에 최적이라고 생각되는 
    // 것을 선택해 나가는 방식으로 진행하여 최종적인 해답에 도달하는 합니다.

    // 문제 해결 - 최적해를 구하기 위한 결정 포인트 정리
    // 1. 모든 원소의 합이 홀수인 경우는 큐의 원소 합이 같을 수가 없으므로 제외합니다.
    // 2. 2번째 종료조건을 "작업횟수 > (1번큐길이+2번큐길이)*2"로 한다.
    //    "작업횟수 > (1번큐길이+2번큐길이)+2" 도 문제에선 통과가 가능하다.  
    //    정확한 기준은 모르겠으나, 중요한건 2개의 큐길이 합 만큼만 순회 시킨다면 
    //    반례가 존재하기 때문에 무조건 길이의 합보다 크게 잡아야 한다는 것이다.
    // 3. 양쪽을 다 계산하는 것은 비효율적이므로 한쪽의 합이 
    //    전체의 반인 경우 결과값인 것으로 판단합니다.
    // 4. 합의 크기에 따라 더할지 뺄지를 정합니다.

    public int solution(int[] q1, int[] q2) {
        int answer = 0;

        long total = 0; // 두 큐의 합
        long q1sum = 0; // 1번 큐의 합
        Queue<Integer> qq1 = new LinkedList<Integer>();
        Queue<Integer> qq2 = new LinkedList<Integer>();

        for(int i = 0; i < q1.length; i++) {
            total += q1[i] + q2[i];
            q1sum += q1[i];
            qq1.add(q1[i]);
            qq2.add(q2[i]);
        }

        if(total%2!=0) return -1; //만약 두큐의합이 홀수면 같게 못만듦.

        long target = total/2;
        while(true) {
            if(answer>(q1.length+q2.length)*2) return -1;//이땐 더 순회해도 못 만듦

            if(q1sum==target) break; // 한쪽의 큐 합을 계산했을 때 전체의 반이라면 종료한다.
            else if(q1sum>target){   // q1sum이 target보다 크다면 
                q1sum -= qq1.peek(); // 큐1 합에는 큐2의 것을 빼고
                qq2.add(qq1.poll()); // 큐2에 큐1의 것을 넣어줍니다.
            }else{                   // q2sum이 target보다 작다면
                q1sum += qq2.peek(); // 큐1 합에는 큐2의 것을 더하고
                qq1.add(qq2.poll()); // 큐1에 큐2의 것을 넣어줍니다.
            }
            answer++;
        }

        return answer;
    }
}