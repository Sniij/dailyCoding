class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int R = 0;
        int T = 0;

        int C = 0;
        int F = 0;

        int J = 0;
        int M = 0;

        int A = 0;
        int N = 0;

        for (int i = 0; i < survey.length; i++){
            String sv = survey[i];
            int cho = choices[i];

            switch (sv) {
                case "RT" -> {
                    switch (cho) {
                        case 1:
                            R += 3;
                            break;
                        case 2:
                            R += 2;
                            break;
                        case 3:
                            R += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            T += 1;
                            break;
                        case 6:
                            T += 2;
                            break;
                        case 7:
                            T += 3;
                            break;
                    }
                }
                case "TR" -> {
                    switch (cho) {
                        case 1:
                            T += 3;
                            break;
                        case 2:
                            T += 2;
                            break;
                        case 3:
                            T += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            R += 1;
                            break;
                        case 6:
                            R += 2;
                            break;
                        case 7:
                            R += 3;
                            break;
                    }
                }
                case "FC" -> {
                    switch (cho) {
                        case 1:
                            F += 3;
                            break;
                        case 2:
                            F += 2;
                            break;
                        case 3:
                            F += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            C += 1;
                            break;
                        case 6:
                            C += 2;
                            break;
                        case 7:
                            C += 3;
                            break;
                    }
                }
                case "CF" -> {
                    switch (cho) {
                        case 1:
                            C += 3;
                            break;
                        case 2:
                            C += 2;
                            break;
                        case 3:
                            C += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            F += 1;
                            break;
                        case 6:
                            F += 2;
                            break;
                        case 7:
                            F += 3;
                            break;
                    }
                }
                case "MJ" -> {
                    switch (cho) {
                        case 1:
                            M += 3;
                            break;
                        case 2:
                            M += 2;
                            break;
                        case 3:
                            M += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            J += 1;
                            break;
                        case 6:
                            J += 2;
                            break;
                        case 7:
                            J += 3;
                            break;
                    }
                }
                case "JM" -> {
                    switch (cho) {
                        case 1:
                            J += 3;
                            break;
                        case 2:
                            J += 2;
                            break;
                        case 3:
                            J += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            M += 1;
                            break;
                        case 6:
                            M += 2;
                            break;
                        case 7:
                            M += 3;
                            break;
                    }
                }
                case "AN" -> {
                    switch (cho) {
                        case 1:
                            A += 3;
                            break;
                        case 2:
                            A += 2;
                            break;
                        case 3:
                            A += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            N += 1;
                            break;
                        case 6:
                            N += 2;
                            break;
                        case 7:
                            N += 3;
                            break;
                    }
                }
                case "NA" -> {
                    switch (cho) {
                        case 1:
                            N += 3;
                            break;
                        case 2:
                            N += 2;
                            break;
                        case 3:
                            N += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            A += 1;
                            break;
                        case 6:
                            A += 2;
                            break;
                        case 7:
                            A += 3;
                            break;
                    }
                }
            }

        }

        if(T>R)
            answer += "T";
        else answer += "R";
        
        if(F>C)
            answer += "F";
        else answer += "C";
        
        if(M>J)
            answer += "M";
        else answer += "J";
        
        if(N>A)
            answer += "N";
        else answer += "A";

        return answer;
    }
}