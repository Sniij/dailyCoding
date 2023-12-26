import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        int tmp = len / 2 - 1;

        for (int i = tmp; i >= 0; i--) {
            heap(works, len, i);
        }

        for (int i = n; i > 0; i--) {
            // 작업할 수 있는 양을 다 소모하거나 작업량이 없으면 break;
            if (works[0] == 0) {
                break;
            }
            works[0] -= 1;
            
            // 이진 트리 재구성
            heap(works, len, 0);
        }

        for (int work : works) {
            answer += Math.pow(work, 2);
        }

        return answer;
    }

    /**
     * 최대 힙 만드는 함수
     * : 부모노드는 자식노드의 키랑 같거나 큼, 완전 이진트리
     * */
    void heap(int[] arr, int n, int i) {
        int maxIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 자식 노드가 지금 노드 보다 크면 maxIdx 로 업데이트
        if ( left < n && arr[left] > arr[maxIdx] ) {
            maxIdx = left;
        }
        if ( right < n && arr[right] > arr[maxIdx] ) {
            maxIdx = right;
        }

        // 만약에 위에서 업데이트 된다면 현재 노드가 자식 노드 볻 ㅏ 작아서 swap 해야됨
        if (maxIdx != i) {
            int swap = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = swap;

            heap(arr, n, maxIdx);
        }
        
    }
}