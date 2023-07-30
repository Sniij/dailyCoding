import java.util.*;


class Solution {
    public static  int[] solution(int k, int[] score) {

        List<Integer> answerList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer i : score) {
            stack.push(i);
            stack.sort(Collections.reverseOrder());

            while (true){
                if(stack.size()<=k)
                    break;
                stack.pop();
            }

            //System.out.println(stack);
            answerList.add(stack.peek());
            //System.out.println(answerList);
        }

        return answerList.stream().mapToInt(value -> value).toArray();
    }
}