import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int el: arr){
            if(!stack.isEmpty()){
                if(stack.peek()!=el){
                    stack.push(el);
                }    
            }
        }
        return stack.stream().mapToInt(el->el).toArray();
    }
}