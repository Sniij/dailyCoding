import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: tangerine){
            if(map.get(i) != null){
                 map.put(i,map.get(i)+1);
            }else{
                 map.put(i,1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer value : map.values()) {
            arr.add(value);
        }

        Collections.sort(arr,Collections.reverseOrder());
        for(Integer a : arr){
            // System.out.println(a);
            answer++;
            k = k - a;
            if((k) <= 0){
                break;
            }
        }
        return answer;
    }
}