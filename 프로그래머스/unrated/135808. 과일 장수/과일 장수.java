import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        long profit = 0;
        int[] counts = new int[k+1];
        
        for(int i : score){
            counts[i]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=k; i>=1; i--){
            while(counts[i]-- > 0){
                pq.add(i);
                if(pq.size() == m){
                    profit += (long)pq.peek() * m;
                    pq.clear();
                }
            }
        }

       return (int)profit; 
    }
}
