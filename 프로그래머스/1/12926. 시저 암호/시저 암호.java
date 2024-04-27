class Solution {
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