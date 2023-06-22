package programmers.level1.fail;

import java.util.*;
import java.util.stream.Collectors;

public class F150370 {

    /*문제 설명
고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다. 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.

모든 달은 28일까지 있다고 가정합니다.
    * */
    public void test(){

        String today1 = "2022.05.19";
        String today2 = "2020.01.01";

        String [] terms1 = {"A 6", "B 12", "C 3"};
        String [] terms2 = {"Z 3", "D 5"};

        String[] privacies1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(solution(today1, terms1, privacies1)));
        System.out.println(Arrays.toString(solution(today2, terms2, privacies2)));

    }


    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String , Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (String term: terms){
            if(term.length()<4){
                hashMap.put(String.valueOf(term.charAt(0)), Integer.parseInt(String.valueOf(term.charAt(2))));
            }else {
                String value = String.valueOf(term.charAt(2))+ term.charAt(3);
                hashMap.put(String.valueOf(term.charAt(0)), Integer.parseInt(value));
            }
        }

        int currentYear = Integer.parseInt(today.substring(0,4));
        int currentMonth = Integer.parseInt(today.substring(5,7));
        int currentDay = Integer.parseInt(today.substring(8,10));
        int cnt=0;

        for (String privacy: privacies ){
            cnt++;
            String type = String.valueOf(privacy.charAt(privacy.length()-1));
            int distance = hashMap.get(type);

            int year = Integer.parseInt(privacy.substring(0,4));
            int month = Integer.parseInt(privacy.substring(5,7));
            int day = Integer.parseInt(privacy.substring(8,10));

            for (int i=1; i<=distance; i++) {
                day += 28;
                if(day > 28){
                    month += 1;
                    day -= 28;
                }
                if(day < 1){
                    month -= 1;
                }
                if(month>12){
                    year += 1;
                    month = 1;
                }
            }

            day--;
            if(day<1){
                month--;
                day = 28;
                if(month<1){
                    year--;
                    month = 12;
                }
            }
            //System.out.println("year: " + year+" month: " + month+" day: " + day);

            if(currentYear>year){
                arrayList.add(cnt);
            } else if(currentYear == year){
                if(currentMonth>month){
                    arrayList.add(cnt);
                } else if (currentMonth == month) {
                    if(currentDay>day){
                        arrayList.add(cnt);
                    }
                }
            }


        }

        //System.out.println(arrayList);

        int[] answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
