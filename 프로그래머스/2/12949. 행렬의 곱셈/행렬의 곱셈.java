class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1 4
        // 3 2
        // 4 1
        
        // 3 3
        // 3 3
        
        // 3x2 * 2x2 = 3x2
        // 1x3+4x3 1x3+4x3
        // 
        
        
        int[][] answer = new int[arr1.length][arr2[0].length];

        
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        
        return answer;
    }
}