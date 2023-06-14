package programmers.level1.pass;

import java.util.*;

public class P178871 {
    /*
        얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

        선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
    * */
    public void test(){

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public String[] solution(String[] players, String[] callings) {

        List<String> playerList = new ArrayList<>(Arrays.asList(players));
        Map<String, Integer> hashMap = new HashMap<>();

        // map에 모든 player, index 담기
        for (int i = 0; i < players.length; i++) {
            hashMap.put(players[i], i);
        }


        for (String calling : callings) {

            // index 가져오기
            int idx = hashMap.get(calling);

            // swap 할 index
            int idx2 = idx - 1 ;

            // 보기 편하게 끔 변수에 담아놈
            String swap = playerList.get(idx);
            String swap2 = playerList.get(idx2);

            // swap
            playerList.set(idx, swap2);
            playerList.set(idx2, swap);

            // swap 한 index 에 맞게 map value-index 수정
            hashMap.put(swap, idx2);
            hashMap.put(swap2, idx);

        }


        return playerList.toArray(new String[0]);
    }

}
