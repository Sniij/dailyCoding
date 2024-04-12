class Solution {
    public static long solution(int k, int d) {
        long answer = 0;

        // x 좌표를 k 배수만큼 증가
        for(int i=0; i<=d; i+=k){
            int yMaxDistance = yPossibleDistance(i, d);
            answer += yPossibleCount(yMaxDistance, k);
        }
        return answer;
    }

    /*
     * 피타고라스 정리
     * y² = d² - x²
     * */
    private static int yPossibleDistance(int x, int d){
        long xx = (long) Math.pow(x, 2);
        long dd = (long) Math.pow(d, 2);

        int result = (int)(Math.sqrt(dd-xx));
        return result;
    }

    // '0'~'y 최대치 정수'에서, k 배수의 숫자가 몇 개 있는지 확인
    private static int yPossibleCount(int possible, int k){
        int y = (possible/k);
        return y+1;
    }
}