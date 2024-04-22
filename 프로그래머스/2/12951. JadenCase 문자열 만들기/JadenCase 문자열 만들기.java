class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();

            for(int i = 0; i < s.length(); i++) {
                String tmp = String.valueOf(s.charAt(i)).toLowerCase();
                try {
                    Integer.parseInt(tmp);
                    answer.append(tmp);
                } catch (Exception e) {
                    for (int j = i; j < s.length(); j++) {
                        char c = s.charAt(j);
                        if (c == ' ') {
                            answer.append(c);
                            answer.append(String.valueOf(s.charAt(j+1)).toUpperCase());
                            i = j + 1;
                            break;
                        } else {
                            answer.append(c);
                        }
                    }
                }
            }
            return answer.toString();
        }
}