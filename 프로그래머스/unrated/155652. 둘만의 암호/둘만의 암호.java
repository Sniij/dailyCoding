class Solution {
    public static String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            char current = c;
            int count = 0;

            while (count < index) {
                current++;

                if (current > 'z') {
                    current = 'a';
                }

                if (skip.indexOf(current) == -1) {
                    count++;
                }
            }

            result.append(current);
        }

        return result.toString();
    }
}