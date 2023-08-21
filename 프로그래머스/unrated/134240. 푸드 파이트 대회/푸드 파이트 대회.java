class Solution {
    public static String solution(int[] food) {

        StringBuilder answer = new StringBuilder();
        int order = -1;
        for (int el: food) {
            order++;

            if(el>=2){
                int tmp = el/2;
                String tmp2 = String.valueOf(order).repeat(tmp);
                answer.append(tmp2);
            }

        }
        StringBuilder reverse = new StringBuilder(answer.reverse().toString());
        answer.reverse();
        answer.append("0");
        answer.append(reverse);

        return answer.toString();
    }
}