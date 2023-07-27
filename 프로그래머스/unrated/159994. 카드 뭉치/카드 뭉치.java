import java.util.*;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        String answer = "";
        int i = 0;
        Stack<String> stack1 = new Stack<>();
        stack1.addAll(Arrays.asList(cards1));
        Collections.reverse(stack1);

        Stack<String> stack2 = new Stack<>();
        stack2.addAll(Arrays.asList(cards2));
        Collections.reverse(stack2);

        for (String el: goal){

            String card1 = "";
            if(!stack1.isEmpty())
                card1 = stack1.peek();

            
            String card2 = "";
            if(!stack2.isEmpty())
                card2 = stack2.peek();

            if(card1.equals(el) ){
                stack1.pop();
                i++;
            }else if(card2.equals(el)){
                stack2.pop();
                i++;
            } else {
                break;
            }

        }

        if(i == goal.length)
            answer = "Yes";
        else
            answer = "No";

        return answer;
    }
}