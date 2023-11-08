class Solution {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i <s.length(); i++) {
            
            if(s.charAt(i) == '0'){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i) == '1'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '2'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '3'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '4'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '5'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '6'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '7'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '8'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '9'){
                sb.append(s.charAt(i));
            } else {
                tmp.append(s.charAt(i));
            }

            switch (tmp.toString()) {
                case "zero" -> {
                    sb.append("0");
                    tmp = new StringBuilder();
                }
                case "one" -> {
                    sb.append("1");
                    tmp = new StringBuilder();
                }
                case "two" -> {
                    sb.append("2");
                    tmp = new StringBuilder();
                }
                case "three" -> {
                    sb.append("3");
                    tmp = new StringBuilder();
                }
                case "four" -> {
                    sb.append("4");
                    tmp = new StringBuilder();
                }
                case "five" -> {
                    sb.append("5");
                    tmp = new StringBuilder();
                }
                case "six" -> {
                    sb.append("6");
                    tmp = new StringBuilder();
                }
                case "seven" -> {
                    sb.append("7");
                    tmp = new StringBuilder();
                }
                case "eight" -> {
                    sb.append("8");
                    tmp = new StringBuilder();
                }
                case "nine" -> {
                    sb.append("9");
                    tmp = new StringBuilder();
                }
            }

        }

        return Integer.parseInt(sb.toString());
    }
}