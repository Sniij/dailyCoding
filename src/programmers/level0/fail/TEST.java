package programmers.level0.fail;

import java.util.*;

public class TEST {

    class Solution {
        // 고객 정보를 저장할 클래스
        static class Member {
            String name;
            int points;
            Member referrer; // 추천인

            Member(String name) {
                this.name = name;
                this.points = 0;
            }
        }

        public String[] solution(String[] members, int p) {
            Map<String, Member> memberMap = new HashMap<>(); // 고객의 이름과 고객 객체를 매핑할 해시맵
            Map<String, Integer> map = new HashMap<>(); // 고객의 이름과 고객 객체를 매핑할 해시맵

            List<Member> memberList = new ArrayList<>(); // 최종 정렬을 위한 리스트
            Stack<Integer> stack = new Stack<>();
            String s = "";
            map.values().stream().mapToInt(el->el).sum();
            map.values().stream().anyMatch(el-> el!=0);
            for (Map.Entry<String, Integer> entry : map.entrySet()){

            }
            char[] chars = s.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            Arrays.sort(chars);
            Arrays.sort(chars, Comparator.reverseOrder());
            Arrays.sort(members, Comparator.reverseOrder());
            memberMap.getOrDefault();
            int[] grade = new int[]{};

            int[] sGrade = Arrays.stream(grade).boxed()..unordered().toArray();

            Map<Character, Integer> cntMap = new HashMap<>();

            for(char el: s.toCharArray()){
                el = Character.toLowerCase(el);

                cntMap.put(el, 8);
            }
            for (String memberInfo : members) {
                String[] info = memberInfo.split(" ");
                String name = info[0];
                String referrerName = info[1];

                Member member = new Member(name);
                if (!"-".equals(referrerName)) { // 추천인이 있는 경우
                    Member referrer = memberMap.get(referrerName);
                    referrer.points += p; // 추천인에게 포인트 지급
                    member.referrer = referrer; // 추천인 설정
                }
                memberMap.put(name, member);
                memberList.add(member);
            }

            // 포인트를 얻는 과정
            for (Member member : memberList) {
                if (member.referrer != null) {
                    int bonus = (int)(p * 0.1); // 추천인 보너스
                    member.referrer.points += bonus;
                }
            }

            // 포인트가 많은 순서대로 정렬, 포인트가 같다면 가입 순서대로 정렬
            memberList.sort((o1, o2) -> o2.points != o1.points ?
                    o2.points - o1.points : memberList.indexOf(o1) - memberList.indexOf(o2));

            // 결과 변환
            String[] answer = new String[memberList.size()];
            for (int i = 0; i < memberList.size(); i++) {
                Member member = memberList.get(i);
                answer[i] = member.name + " " + member.points;
            }

            return answer;
        }

        public long solution(long n) {

            char[] numbers = String.valueOf(n).toCharArray();
            Arrays.sort(numbers);

            return Long.parseLong(new StringBuilder(new String(numbers)).reverse().toString());
        }

        public String solution(String s, int n) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isLowerCase(ch)) {
                    // 소문자인 경우
                    ch = (char) ((ch - 'a' + n) % 26 + 'a');
                } else if (Character.isUpperCase(ch)) {
                    // 대문자인 경우
                    ch = (char) ((ch - 'A' + n) % 26 + 'A');
                }
                // 공백인 경우는 그대로 둔다 (ch에 대한 조작 없음)

                result.append(ch);
            }

            return result.toString();
        }

    }

}
