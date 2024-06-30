import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        // record는 10^5
        // Enter = 입장, Leave = 떠남, Change = 바꿈
        HashMap<String,String> userMap = new HashMap<>();
        for(String r : record){
            String[] arr = r.split(" ");
            if(!arr[0].equals("Leave")){
                userMap.put(arr[1],arr[2]);
            }
        }

        ArrayList<String> resultArr = new ArrayList<>();
        for(String r : record){
            String[] arr = r.split(" ");
            if(arr[0].equals("Enter")){
                resultArr.add(userMap.get(arr[1])+"님이 들어왔습니다.");
            }else if(arr[0].equals("Leave")){
                resultArr.add(userMap.get(arr[1])+"님이 나갔습니다.");
            }
        }

        // String[] answer = new String[]{};
        return resultArr;
    }
}