import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] leftCumulativeSum = getLeftCumulativeSum(topping);
        int[] rightCumulativeSum = getRightCumulativeSum(topping);
        int answer = getCount(leftCumulativeSum, rightCumulativeSum);
        return answer;
    }

    private int getCount(int[] leftCumulativeSum, int[] rightCumulativeSum) {  
        int count = 0;
        for(int idx=0; idx<leftCumulativeSum.length-1; idx++) {
            if(leftCumulativeSum[idx] == rightCumulativeSum[idx+1]) {
                count++;
            }
        }
        return count;
    }

    // 0~i idx까지의 조각의 종류 개수
    private int[] getLeftCumulativeSum(int[] topping) {
        int[] arr = new int[topping.length];
        Set<Integer> alreadyIn = new HashSet<>();
        for(int i=0, count=0; i<topping.length; i++) {
            int num = topping[i];
            if(!alreadyIn.contains(num)) {
                alreadyIn.add(num);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }

    //N-1 ~ i idx까지의 조각의 종류의 개수
    private int[] getRightCumulativeSum(int[] topping) {
        int[] arr = new int[topping.length];
        Set<Integer> alreadyIn = new HashSet<>();
        for(int i=topping.length-1, count=0; i>=0; i--) {
            int num = topping[i];
            if(!alreadyIn.contains(num)) {
                alreadyIn.add(num);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }

}