import java.util.*;

class Solution {
    private static char[][] room;
    private static List<int[]> people;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean flag;

    public static int[] solution(String[][] places) {
        List<Integer> ans = new ArrayList<>();

        room = new char[5][5];

        // 행렬이 다섯번 주어짐
        for (int i = 0; i < 5; i++) {
            people = new ArrayList<>();
            visited = new boolean[5][5];
            flag = true;

            // 'P'의 좌표 저장
           for (int j = 0; j < 5; j++) {
                char[] tmp = places[i][j].toCharArray();
                for (int k = 0; k < 5; k++) {
                    room[j][k] = tmp[k];
                    if (room[j][k] == 'P') {
                        people.add(new int[]{j, k});
                    }
                }
            }

            // dfs탐색
            for(int t=0; t<people.size(); t++){
                int[] person = people.get(t);
                dfs(person[0], person[1], person[0], person[1]);
            }

            if(flag) ans.add(1);
            else ans.add(0);
        }

        // list -> array
        return Arrays.stream(ans.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }

    /*
    * x : 현재 가로 위치
    * y : 현재 세로 위치
    * ax : 'P'가 있는 가로 위치. 이 값을 기준으로 맨해튼 거리 계산
    * ay : 'P'가 있는 세로 위치. 이 값을 기준으로 맨해튼 거리 계산
    * */
    private static void dfs(int x, int y, int ax, int ay) {
        visited[x][y] = true;

        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!inBound(nx, ny)) continue;

            // 거리가 2 이하인 곳을 탐색
            if(inDistance(ax, ay, nx, ny)) {
                if (room[nx][ny] == 'P' || room[nx][ny] == 'O') {
                    dfs(nx, ny, ax, ay);

                    if(room[nx][ny] == 'P') flag = false;
                }
            }
        }
    }

    // 맨해튼 거리
    private static boolean inDistance(int x1, int y1, int x2, int y2){
        int xd = Math.abs(x2-x1);
        int yd = Math.abs(y2-y1);

        return (xd + yd) <= 2 ? true : false;
    }

    // 탐색 위치가 내부에 있으며, 이전에 방문했는지 확인
    private static boolean inBound(int x, int y) {
        if (x >= 0 && y >= 0 && x < 5 && y < 5 && !visited[x][y]) return true;
        return false;
    }
}