class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int i = 0; i < arr1.length; i++){
            int[] row1 = arr1[i];
            int[] row2 = arr2[i];
            
            for(int j = 0; j < row1.length; j++){
                answer[i][j] = row1[j] + row2[j];
            }
            
        }
    
        
        return answer;
    }
}