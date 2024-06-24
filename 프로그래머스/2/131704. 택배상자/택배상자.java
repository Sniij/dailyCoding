import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        //보조 컨테이너 벨트
        Stack<Integer> stack2 = new Stack<>();

        //기존 컨테이너 벨트
        Stack<Integer> stack1 = new Stack<>();

        for(int i=0;i<order.length;i++){
            stack1.push(order.length-i);
        }

        while(order[0]!=stack1.peek()){
            stack2.push(stack1.pop());
        }

        answer++;
        stack1.pop();

        for(int i=1;i<order.length;i++){
            //System.out.println(order[i]);

            if(!stack1.isEmpty() && order[i]==stack1.peek()){

                answer++;
                stack1.pop();
            }else if(!stack2.isEmpty() &&order[i]==stack2.peek()){

                answer++;
                stack2.pop();
            }else{
                //System.out.println(stack1.peek());

                if(!stack1.isEmpty() && stack1.peek()<order[i]){  

                    while(order[i]!=stack1.peek()){

                        stack2.push(stack1.pop());
                    }
                    answer++;
                    stack1.pop();
                    //System.out.println("!!"+stack2.peek());

                }else{
                    break;
                }

            }
        }

        return answer;
    }


}