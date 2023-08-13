package programmers.level1.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class F160586 {

    public void test(){

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD","AABB"};

        System.out.println(Arrays.toString(solution(keymap1, targets1)));


        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};

        System.out.println(Arrays.toString(solution(keymap2, targets2)));


        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA","BGZ"};

        System.out.println(Arrays.toString(solution(keymap3, targets3)));

    }

    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];
        int idxAns = 0;
        int idxMap = 1;

        for (String key : keymap) {

            Map<String, Integer> hashMap = new HashMap<>();
            idxMap = 1;
            for (int i = 0; i < key.length(); i++) {
                String tmp = String.valueOf(key.charAt(i));
                if(!hashMap.containsKey(tmp)){
                    hashMap.put(tmp, idxMap);
                }
                idxMap++;
            }

            System.out.println("current:" + hashMap);

            for (String target: targets){
                for (int i = 0; i < target.length(); i++) {
                    String tmp = String.valueOf(key.charAt(i));

                    if(hashMap.containsKey(tmp)){
                        answer[idxAns] += hashMap.get(tmp);
                    }
                }
            }

            idxAns++;
        }


        return answer;
    }

}
