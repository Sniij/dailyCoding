class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        
        int[] dh = new int[]{0,1,-1,0};
        int[] dw = new int[]{1,0,0,-1};
        
        for(int i = 0; i < 4; i++){
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];

            if( 0 <= hCheck && 0 <= wCheck ){
                if( hCheck < n && wCheck < n ){
                    if( board[h][w].equals(board[hCheck][wCheck]) ) answer++;
                }    
            }
            
        }
        
        return answer;
    }
}