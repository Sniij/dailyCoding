import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public static int[] solution(String[] keymap, String[] targets) {


        Map<Character, List<Integer>> map = new HashMap<>();

        IntStream.range(0, keymap.length).forEach(i ->
                IntStream.range(0, keymap[i].length()).forEach(j ->
                        map.computeIfAbsent(keymap[i].charAt(j), k -> new ArrayList<>()).add(j + 1)
                )
        );


        return Arrays.stream(targets)
                .mapToInt(target -> target.chars()
                        .boxed()
                        .reduce(0,
                                (sum, c) -> sum >= 0 && map.containsKey((char)c.intValue()) ? sum + Collections.min(map.get((char)c.intValue())) : -1,
                                (a, b) -> a < 0 || b < 0 ? -1 : a + b))
                .toArray();
    }
}