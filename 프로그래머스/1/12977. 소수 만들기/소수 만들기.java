import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int cnt=0;
        boolean[] isUse = new boolean[nums.length];
        List<Integer> sum = new ArrayList<>();
        
        for(int i = 0; i< nums.length; i++ ){
            for(int j = i+1; j< nums.length; j++ ){
                for(int k = j+1; k< nums.length; k++ ){
                    sum.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        
        
        for(int num: sum){
            //System.out.println("num = " + num);

            if(isPrime(num)) cnt++;
        }
            
        return cnt;
    }
    
    
    public boolean isPrime(int num){
        
        int cnt = 0;
        
        for(int i=1; i<=num; i++){
            if(num % i == 0) cnt++;
        }
        
        if(cnt==2) return true;
        return false;
    }
}