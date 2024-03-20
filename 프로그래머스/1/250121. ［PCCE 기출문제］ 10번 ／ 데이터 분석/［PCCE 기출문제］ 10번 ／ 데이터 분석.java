import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int standard = determine(ext);
        int sort = determine(sort_by);
        
        // ext 값이 val_ext보다 작은 데이터만 필터링합니다.
        int[][] filteredData = Arrays.stream(data)
                .filter(d -> d[standard] < val_ext)
                .toArray(int[][]::new);

        // sort_by에 해당하는 값을 기준으로 오름차순 정렬합니다.
        Arrays.sort(filteredData, Comparator.comparingInt(a -> a[sort]));

        return filteredData;
        
        
    }
    
    
    public int determine(String str){
        switch (str) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return 0;
        }
    }
}