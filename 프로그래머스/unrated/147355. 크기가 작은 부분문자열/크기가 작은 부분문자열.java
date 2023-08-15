class Solution {
    public static int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        Long pInt = Long.parseLong(p);
        StringBuilder sb;

        for (int i = 0; i<=t.length()-pLength; i++){

            sb = new StringBuilder();

            for (int j=i; j<i+pLength; j++){
                //System.out.println("char = " + t.charAt(j));
                sb.append(t.charAt(j));
            }

            Long tInt = Long.parseLong(sb.toString());
            //System.out.println("tInt = " + tInt +" pInt = " + pInt);

            if(pInt>=tInt) answer++;

        }


        return answer;
    }
}