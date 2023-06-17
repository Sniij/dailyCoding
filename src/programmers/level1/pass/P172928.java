package programmers.level1.pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P172928 {



    public void test(){

        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));

        String[] park3 = {"SOO","OXX","OOO"};
        String[] routes3 = {"E 2","S 2","W 1"};

        System.out.println(Arrays.toString(solution(park3, routes3)));

        String[] park2 = {"OSO","OOO","OXO","OOO"};
        String[] routes2 = {"E 2","S 3","W 1"};

        System.out.println(Arrays.toString(solution(park2, routes2)));

    }


    public int[] solution(String[] park, String[] routes) {

        String [][] architecture = new String[park.length][park[0].length()];
        int idxRow = 0;
        int idxCol = 0;
        int[] indexOfS = new int[2];

        for(String s : park){
            idxCol = 0;
            for (int i = 0; i <s.length(); i++) {
                String data = String.valueOf(s.charAt(i));
                architecture[idxRow][idxCol++] = data;

                if(data.equals("S")){
                    indexOfS[0] = idxRow;
                    indexOfS[1] = idxCol-1;
                }

            }
           idxRow++;
        }


        ArrayList<ArrayList<String>> archList = Arrays.stream(architecture)
                .map(row -> new ArrayList<>(Arrays.asList(row)))
                .collect(Collectors.toCollection(ArrayList::new));

        //System.out.println(archList);
        //System.out.println(Arrays.toString(routes));
        //System.out.println(Arrays.toString(indexOfS));

        for (String r: routes){

            String direction = String.valueOf(r.charAt(0));
            int distance = Integer.parseInt(String.valueOf(r.charAt(2)));
            int currentRow = indexOfS[0];
            int currentCol = indexOfS[1];
            boolean found = false;

            switch(direction){
                case "E":
                    if(currentCol+distance >= archList.get(currentCol).size()) break;
                    for (int i = currentCol; i <= currentCol+distance; i++){
                        if (archList.get(currentRow).get(i).equals("X")) {
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        indexOfS[1] += distance;
                        //System.out.println(Arrays.toString(indexOfS));
                    }

                    break;
                case "W":
                    if(currentCol-distance<0) break;
                    for (int i = currentCol; i >= currentCol-distance; i--){
                        if (archList.get(currentRow).get(i).equals("X")) {
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        indexOfS[1] -= distance;
                        //System.out.println(Arrays.toString(indexOfS));
                    }

                    break;
                case "S":
                    if(currentRow+distance >= archList.size()) break;

                    for (int i = currentRow; i <= currentRow+distance; i++){
                        if(archList.get(i).get(currentCol).equals("X")){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        indexOfS[0] += distance;
                        //System.out.println(Arrays.toString(indexOfS));
                    }

                    break;
                default:
                    if(currentRow-distance<0) break;

                    for (int i = currentRow; i >= currentRow-distance; i--){
                        if(archList.get(i).get(currentCol).equals("X")){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        indexOfS[0] -= distance;
                        //System.out.println(Arrays.toString(indexOfS));
                    }

                    break;
            }

        }

        return indexOfS;
    }
}
