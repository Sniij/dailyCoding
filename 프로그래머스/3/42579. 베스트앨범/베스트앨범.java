import java.util.*;

class Solution {

    // 노래 정보를 저장하기 위한 클래스 정의
    class Song implements Comparable<Song> {
        int id;
        int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        // 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
        @Override
        public int compareTo(Song other) {
            if (this.playCount == other.playCount) {
                return this.id - other.id;
            }
            return other.playCount - this.playCount;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> mapPlayCnt = new HashMap<>();
        Map<String, PriorityQueue<Song>> mapSong = new HashMap<>();

        // 장르별 총 재생 횟수와 노래 정보 저장
        for (int i = 0; i < genres.length; i++) {
            mapPlayCnt.put(genres[i],
                        mapPlayCnt.getOrDefault(genres[i], 0) + plays[i]);

            mapSong.computeIfAbsent(genres[i], k -> new PriorityQueue<>())
                    .add(new Song(i, plays[i]));
        }


        // 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<String> listPlayCnt = new ArrayList<>(mapPlayCnt.keySet());
        listPlayCnt.sort((a, b) -> mapPlayCnt.get(b) - mapPlayCnt.get(a));

        // 장르별로 가장 많이 재생된 노래 2개씩 선택
        for (String genre : listPlayCnt) {
            PriorityQueue<Song> songs = mapSong.get(genre);
            int count = 0;
            while (!songs.isEmpty() && count < 2) {
                answer.add(songs.poll().id);
                count++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}