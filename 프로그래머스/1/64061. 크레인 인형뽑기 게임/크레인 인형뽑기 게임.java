import java.util.*;
class Solution {
    private static int[][] board;
    private static Stack<Integer> stack;
    private static int disappeared = 0;

    private void method(int move , int i){
        if(i == board.length){
            return;
        }else if(board[i][move-1] != 0){
            checkStack(board[i][move-1]);
            board[i][move-1] = 0;
            return;
        }
        method(move, ++i);

    }
    private void checkStack(int element){
        if(!stack.empty() && stack.peek() == element){
            System.out.println(stack.peek());
            stack.pop();
            disappeared += 2;

        }else{
            stack.push(element);
            System.out.println(stack.peek());
        }
    }
    public int solution(int[][] board, int[] moves) {
        this.board = board;
        this.stack = new Stack<Integer>();
        for(int move : moves){
            method(move, 0);
        }
        int answer = disappeared;
        return answer;
    }
}