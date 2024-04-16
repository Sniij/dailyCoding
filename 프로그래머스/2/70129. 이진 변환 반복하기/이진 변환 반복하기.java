class Solution {

    static int cnt = 0;
    static int allcount = 0;

    public int[] solution(String s) {
        int[] answer = new int [2];
        delete(s);
        answer[0] = allcount;
        answer[1] = cnt;
        return answer;
    }

    private static String delete(String binary) {

        //binary 값이 1이 되면 호출한 부분으로 돌아간다.
        if(binary.equals("1"))
            return "";

        int zerocount = 0;
        //0의 개수 출력
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '0')
                zerocount++;
        }
        //cnt는 총 0을 뺀 개수
        cnt += zerocount;
        //length는 0제거 후의 길이
        int length = binary.length() - zerocount;
        //allcount는 몇 번 반복됬는지 확인하는 변수
        allcount++;

        return delete(Integer.toString(length,2));
    }
}