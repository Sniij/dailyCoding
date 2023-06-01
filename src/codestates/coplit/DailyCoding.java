package codestates.coplit;

import java.util.*;
import java.util.stream.Collectors;


public class DailyCoding {

    public static void main(String[] args) {

       int output = orderOfPresentation(3,new int[]{2,1,3});
       int output2 = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});

        System.out.println(output +" "+ output2);
    }

    // 1. 배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴해야 합니다.
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if(arr.length==0) return null;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(arr[0],arr[arr.length-1]);
        return hashMap;
    }

    // 2. 연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다.
    public int computeWhenDouble(double interestRate) {
        interestRate = 1 + interestRate*0.01;
        double account =1;
        int years = 0;
        while (account<2){
            account = account * interestRate;
            years++;
        }
        return years;
    }

    // 3. 수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.
    public boolean powerOfTwo(long num) {
        // 금지된 문자열은 주석까지 확인합니다.
        // TODO:
        if(num==1)
            return true;
        long two = 2;
        while (two<num) {
            two = two * 2;
        }
        return two==num;
    }

    // 4. 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자로 이루어진 문자열을 리턴해야 합니다.
    public String firstCharacter(String str) {
        // TODO:
        if(str.isEmpty()) return "";
        StringBuilder output = new StringBuilder(String.valueOf(str.charAt(0)));
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)==' ') output.append(str.charAt(i + 1));
        }
        return output.toString();
    }

    // 5. 문자열을 입력받아 순서가 뒤집힌 문자열을 리턴해야 합니다.
    public String firstReverse(String str) {
        // TODO:
        if(str.isEmpty()) return "";
        StringBuilder output = new StringBuilder(str);
        return output.reverse().toString();
    }

    public void gugudan(int level, int count){
        if(count>9) return;

        System.out.printf("%d x %d = %d\n", level, count, level*count);

        gugudan(level, ++count);
    }

    public static int factorial(int number){
        if(number<=1) return 1;
        return factorial(number-1)*number;
    }

    // 6. 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴해야 합니다.
    public static String letterCapitalize(String str) {
        if(str.isEmpty()) return "";

        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++){
            if(arr[i].isEmpty())
                arr[i] = "";
            else
                arr[i] = String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
            System.out.println(arr[i]);
        }

        String result= String.join(" ", arr);

        return result;
    }

    // 7. 2차원 배열(배열을 요소로 갖는 배열)을 입력받아 각 배열을 이용해 만든 HashMap을 리턴해야 합니다.
    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        HashMap<String,String> hashMap = new HashMap<>();

        if(arr.length==0) return hashMap;

        for(var data : arr){
            if(data.length==0 ||hashMap.containsKey(data[0]) ) continue;

            hashMap.put(data[0],data[1]);
        }
        return hashMap;
    }

    // 8. 문자열을 입력받아 해당 문자열에 등장하는 두 칸의 공백을 모두 한 칸의 공백으로 바꾼 문자열을 리턴해야 합니다.
    public String convertDoubleSpaceToSingle(String str) {
        return str.replaceAll("  ", " ");
    }

    // 9. 문자열을 입력받아 문자열 내에 아래 중 하나가 존재하는지 여부를 리턴해야 합니다.
    public boolean ABCheck(String str) {
        char[] strArr = str.toCharArray();
        for (int i=0; i<strArr.length-4; i++) {
            if(strArr[i]=='a'|| strArr[i]=='A')
                if(strArr[i+4]=='b' ||strArr[i+4]=='B') return true;
            if(strArr[i]=='b'|| strArr[i]=='B')
                if(strArr[i+4]=='a' ||strArr[i+4]=='A') return true;
        }
        return false;
    }

    // 10. 문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴해야 합니다.
    public static String insertDash(String str) {
        if(str.isEmpty()) return null;

        LinkedList<String> linkedList = Arrays
                .stream(str.split(""))
                //.map(Integer::parseInt)
                .collect(Collectors
                        .toCollection(LinkedList::new));

        for (int i =0; i<linkedList.size()-1; i++) {
            if(Integer.parseInt(linkedList.get(i))%2!=0 && Integer.parseInt(linkedList.get(i+1))%2!=0)
                linkedList.add(++i, "-");
        }
        //45-7-9496


        return linkedList.toString()
                        .replaceAll(",","")
                        .replaceAll(" ","")
                        .replaceAll("\\[","")
                        .replaceAll("\\]","");
    }

    // 11. 문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.
    public static String[] removeExtremes(String[] arr) {
        if(arr.length==0) return null;

        LinkedList<String> linkedList = Arrays
                .stream(arr)
                .collect(Collectors
                        .toCollection(LinkedList::new));

        int min = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();
        int max = Arrays.stream(arr).mapToInt(String::length).min().getAsInt();
        int minIndex = 0;
        int maxIndex = 0 ;
        for (int i=0; i<linkedList.size(); i++){
            if(min==linkedList.get(i).length())
                minIndex = i;
            if(max==linkedList.get(i).length())
                maxIndex = i;
        }
       // System.out.println(linkedList.size());
       // System.out.println(minIndex+" " +maxIndex);

        if(minIndex<maxIndex) {
            linkedList.remove(maxIndex);
            linkedList.remove(minIndex);
        }
        else {
            linkedList.remove(minIndex);
            linkedList.remove(maxIndex);
        }
        return linkedList.toArray(new String[linkedList.size()]);
    }

    // 12. 배열을 입력받아 순서가 뒤집힌 배열을 리턴해야 합니다. 재귀형태로 작성
    public int[] reverseArr(int[] arr){
        if(arr.length==0) return new int[]{};

        int[] head = Arrays.copyOfRange(arr,arr.length-1,arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] res = new int[head.length+tail.length];
        System.arraycopy(head,0,res,0,head.length);
        System.arraycopy(tail,0,res,head.length,tail.length);
        return res;
    }

    // 13. 문자열을 요소로 갖는 배열을 입력받아 문자열을 세로로 읽었을 때의 문자열을 리턴해야 합니다.
    public String readVertically(String[] arr) {
        String[] tmp = new String[Arrays.stream(arr).mapToInt(String::length).max().getAsInt()];

        for (String str: arr) {
            for (int i=0; i<str.length(); i++){
                if(tmp[i]==null){
                    tmp[i] = String.valueOf(str.charAt(i));
                } else {
                    tmp[i] += String.valueOf(str.charAt(i));
                }

            }
        }
        String res = "";
        for (String str: tmp) {
            res += str;
        }

        return res;
        //Arrays.toString(tmp).replaceAll("\\[","").replaceAll(",","");
    }

    // 14. 수를 요소로 갖는 배열을 입력받아 각 요소들이 그 이전의 요소들의 합보다 큰지 여부를 리턴해야 합니다.
    public static boolean superIncreasing(int[] arr) {
        int tmp =arr[0];
        for (int i =1; i<arr.length; i++){
            if(arr[i]<=tmp) return false;
            tmp += arr[i];
        }
        return true;
    }

    // 15. 두 수(num1, num2)를 입력받아, num1를 num2로 나눈 나머지를 리턴해야 합니다.
    public Integer modulo(int num1, int num2) {
        if(num2==0) return null;

        while (true){
            if(num1<=0) {
                if(num1<0) num1+=num2;
                return num1;
            }
            num1 = num1-num2;
        }
    }

    // 16. 문자열을 입력받아 아이소그램인지 여부를 리턴해야 합니다. 아이소그램(isogram)은 각 알파벳을 한번씩만 이용해서 만든 단어나 문구를 말합니다.
    public static boolean isIsogram(String str) {
        if(str.isEmpty()) return true;

        str = str.toUpperCase();
        LinkedList<String> linkedList = Arrays.stream(str.split(""))
                                            .collect(Collectors.toCollection(LinkedList::new));

        for (int i=0; i<linkedList.size(); i++){
            String tmp = linkedList.remove();
            if(linkedList.contains(tmp)) return false;
        }
        return true;
    }

    // 17. 수를 입력받아 제곱근 값을 소수점 두 자리까지 리턴해야 합니다.
    public String computeSquareRoot(int num) {
        double x = 1;
        double[] diffs = new double[]{1,0.1,0.01,0.001};

        for(int i=0; i<diffs.length; i++){
            while (x*x<num){
                x = x + diffs[i];
            }
            if(x*x == num) return String.format("%.2f", x);
            else x = x - diffs[i];
        }

        return String.format("%.2f", x);

    }

    // 18. 문자열을 입력받아 문자열에서 숫자를 모두 찾아 더한 뒤에 해당 값을 (숫자와 공백을 제외한 나머지) 문자열의 길이로 나눈 값을 정수로 반올림하여 리턴해야 합니다.
    public static int numberSearch(String str) {
        if(str.isEmpty()) return 0;

        str = str.replaceAll(" ", "");
        LinkedList<String> linkedList = Arrays.stream(str.split(""))
                                                //.map(Integer::parseInt)
                                                .collect(Collectors.toCollection(LinkedList::new));

        double sum=0;

        for (int i=0; i<linkedList.size(); i++){
            for (int j=0; j<10; j++){
                if(String.valueOf(j).equals(linkedList.get(i))) {
                    sum += j;
                    linkedList.remove(i);
                    i--;
                    break;
                }
            }
        }

        sum = sum/linkedList.size();
        return (int)Math.round(sum);

    }

    // 19. 암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴해야 합니다.
    // 카이사르 암호(Caesar cipher)는 평문(plaintext)을 암호키 secret 개 만큼 (오른쪽으로) 평행이동시켜 암호화 합니다. 복호화는 암호화된 문자열을 원래의 평문으로 복원하는 것을 말합니다.
    public static String decryptCaesarCipher(String str, int secret) {
        if(str.isEmpty()) return "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder ans = new StringBuilder();

        for(char data : str.toCharArray()){

            if(Character.isLowerCase(data)){

                int index = (alphabet.indexOf(data) - secret + alphabet.length()) % alphabet.length();
                ans.append(alphabet.charAt(index));
            }
            else ans.append(data);

        }
        return ans.toString();
    }

    // 20. 문자열을 입력받아 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴해야 합니다.
    public String compressString(String str) {
        if(str.isEmpty()) return "";

        StringBuilder ans = new StringBuilder();

        str = str+ ' ';
        char[] strArr = str.toCharArray();

        char before = strArr[0];
        int cnt = 1;

        for(int i=1; i<strArr.length; i++){
            if(before == strArr[i]){
                cnt++;
            }
            else {
                if(cnt>=3)
                    ans.append(cnt).append(before);
                else {
                    for(int j=0; j<cnt; j++){
                        ans.append(before);
                    }
                }
                cnt = 1;
                before =strArr[i];
            }
        }

        return ans.toString();
    }

    // 21. 정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴해야 합니다. 배열의 요소는 음수와 0을 포함하는 정수입니다.
    public int largestProductOfThree(int[] arr) {
        Arrays.sort(arr);
        int max0 = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        int max1 = arr[0] * arr[1] * arr[arr.length-1];

        return Math.max(max0,max1);

    }

    // 22. 정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.
    //버블 정렬(bubble sort)은 여러 정렬 알고리즘(삽입 정렬, 퀵 정렬, 병합 정렬, 기수 정렬 등) 중 가장 기본적인 알고리즘입니다.
    //
    //버블 정렬 알고리즘은 아래와 같습니다.
    //
    //첫 번째 요소가 두 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
    //두 번째 요소와 세 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
    //1, 2를 마지막까지 반복합니다. (마지막에서 두 번째 요소와 마지막 요소를 비교)
    //1~3의 과정을 한 번 거치게 되면, 가장 큰 요소가 배열의 마지막으로 밀려납니다.
    //1~3의 과정을 첫 요소부터 다시 반복합니다.
    //5를 통해 두 번째로 큰 요소가 배열의 마지막 바로 두 번째로 밀려납니다.
    //1~3의 과정을 총 n번(배열의 크기) 반복합니다.

    public static int[] bubbleSort(int[] arr) {

        int tmp;
        int arrLength = arr.length;
        for (int i=0; i<arrLength; i++){
            int swap = 0;
            for (int j=0; j<arrLength-1; j++){
                if(arr[j]>arr[j+1]){
                   tmp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = tmp;
                   swap++;
                }
            }
            if(swap==0) break;
        }

        return arr;
    }

    // 23. 아래와 같이 정의된 피보나치 수열 중 n번째 항의 수를 리턴해야 합니다.
    //0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1입니다. 그 다음 2번째 피보나치 수부터는 바로 직전의 두 피보나치 수의 합으로 정의합니다.
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
    public int fibonacci(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);

        return aux(arrayList,num);
    }
    public int aux(ArrayList<Integer> arrayList, int num){
        if(arrayList.size()<=num){
            arrayList.add(aux(arrayList,num-1)+aux(arrayList,num-2));
        }

        return arrayList.get(num);
    }


    // 24. 두 개의 배열(base, sample)을 입력받아 sample이 base의 부분집합인지 여부를 리턴해야 합니다.
    public boolean isSubsetOf(int[] base, int[] sample) {

        for (int i=0; i<sample.length; i++){
            boolean flag = false;
            for (int j=0; j<base.length; j++){
                if (sample[i] == base[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    // 25. 두 수를 입력받아 거듭제곱을 리턴해야 합니다.
    public long power(int base, int exponent) {
        long mul = base;

        for (int i=1; i<exponent; i++){
            mul = mul*base;
            mul = mul%94_906_249;
        }

        return mul;
    }

    // 26. 임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아, 해당 노드를 시작으로 깊이 우선 탐색(DFS, Depth First Search)을 합니다. 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.
    public ArrayList<String> dfs(tree node) {

        ArrayList<String> values = new ArrayList<>();
        values.add(node.getValue());

        if(node.getChildrenNode()!=null){
            for (int i =0; i<node.getChildrenNode().size(); i++){
                ArrayList<String> list = dfs(node.getChildrenNode().get(i));
                values.addAll(list);
            }
        }

        return values;
    }

    // 27. 임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아, 해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 합니다. 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.
    public ArrayList<String> bfs(tree node) {
        Queue<tree> queue = new LinkedList<>();
        queue.add(node);

        ArrayList<String> arrayList = new ArrayList<>();

        while (!queue.isEmpty()){
            tree data = queue.remove(); // queue 에서 하나 꺼내고
            arrayList.add(data.getValue()); // 리스트에 삽입 후

            if(data.getChildrenNode()!=null){ // children node 있으면 queue 에 다시 넣어주기
                queue.addAll(data.getChildrenNode());
            }
        }

        return arrayList;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private final String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }


    // 28. 문자열을 입력받아 문자열 내의 모든 괄호의 짝이 맞는지 여부를 리턴해야 합니다.
    //
    //다음 단계에 맞춰 함수를 작성해 보세요
    //괄호의 종류를 단 한가지로 한정합니다.
    //괄호의 종류를 늘려 모든 종류의 괄호에도 작동하도록 합니다.
    //괄호를 제외한 문자열이 포함된 경우에도 작동하도록 합니다.
    //괄호는 닫힌 괄호 (, [, { 가 시작되면, 이후로 열린 괄호가 입력될 수 없습니다 (이럴 경우 실패)

    public static boolean balancedBrackets(String str) {

        boolean flag = false;
        int cnt1 = 0, cnt2=0;

        LinkedList<String> linkedList = Arrays.stream(str.split(""))
                                                .collect(Collectors.toCollection(LinkedList::new));

        LinkedHashMap<Boolean, String> linkedHashMap = new LinkedHashMap<>();



        for(int i=0; i<linkedList.size(); i++){
            String data = linkedList.get(i);

            if (data.equals("(")){
                for (int j=i+1; j< linkedList.size(); j++){

                     if(linkedList.get(j).equals(")")){
                        linkedList.remove(j);
                        linkedList.remove(data);
                        i--;
                        break;
                    }
                }
            }
            else if (data.equals("[")){
                for (int j=i+1; j< linkedList.size(); j++){
                    if(linkedList.get(j).equals("]")){
                        linkedList.remove(j);
                        linkedList.remove(data);
                        i--;
                        break;
                    }
                }
            }
            else if (data.equals("{")){
                for (int j=i+1; j< linkedList.size(); j++){
                    if(linkedList.get(j).equals("}")){
                        linkedList.remove(j);
                        linkedList.remove(data);
                        i--;
                        break;
                    }
                }
            }
        }

        return linkedList.isEmpty() || str.isEmpty();
    }

    // 29. 세로 길이 2, 가로 길이 n인 2 x n 보드가 있습니다. 2 x 1 크기의 타일을 가지고 이 보드를 채우는 모든 경우의 수를 리턴해야 합니다.
    public int tiling(int num) {
        /**
         * 0 => 0
         * 1 => 1
         * 2 => 2
         * 3 => 3
         * 4 => 5
         * 5 => 8
         * 6 => 13
         * */
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        return aux(num, arrayList);
    }
    public int aux(int size, ArrayList<Integer> arrayList){

        if(size<arrayList.size()) return arrayList.get(size);
        arrayList.add(aux(size-1, arrayList) + aux(size-2, arrayList));
        return arrayList.get(size);

    }

    // 30. 부분적으로 오름차순 정렬*된 정수의 배열(rotated)과 정수(target)를 입력받아 target의 인덱스를 리턴해야 합니다.
    //
    //부분적으로 정렬된 배열: 배열을 왼쪽 혹은 오른쪽으로 0칸 이상 순환 이동할 경우 완전히 정렬되는 배열
    //예시: [4, 5, 6, 0, 1, 2, 3]은 왼쪽으로 3칸 또는 오른쪽으로 4칸 순환 이동할 경우 완전히 정렬됩니다.
    public int rotatedArraySearch(int[] rotated, int target) {

        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.stream(rotated).boxed().collect(Collectors.toList());

        int half = arrayList.size() / 2;

        if (arrayList.get(half) > target) {
            for (int i = 0; i < half; i++) {
                if (arrayList.get(i) == target) return i;
            }
            for (int i = half; i<arrayList.size(); i++){
                if (arrayList.get(i) == target) return i;
            }
        }else {
            for (int i = half; i < arrayList.size(); i++) {
                if (arrayList.get(i) == target) return i;
            }
            for (int i = 0; i < half; i++) {
                if (arrayList.get(i) == target) return i;
            }
        }

        return -1;
    }

    // 31. 하나의 집합을 의미하는 문자열을 입력받아 각 문자를 가지고 만들 수 있는 모든 부분집합을 리턴해야 합니다.
    public static ArrayList<String> powerSet(String str) {

        ArrayList<String> arrayList = new ArrayList<>();
        if(str.isEmpty()) return arrayList;


        String str2 = "";
        for (int i = 0; i < str.length(); i++){
            if(str.indexOf(str.charAt(i))==i){
                str2 += str.charAt(i);
            }
        }
        String[] sort = str2.split("");
        Arrays.sort(sort);
        str2 = String.join(",",sort).replaceAll(",","");


        Stack<String> stack = new Stack<>();
        arrayList = pickOrNot(stack, 0, str2, arrayList);
        Collections.sort(arrayList);

        return arrayList;
    }
    private static ArrayList<String> pickOrNot(Stack<String> stack, int i, String str2, ArrayList<String> arrayList) {
        if(i >= str2.length()){
            arrayList.add(stack.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",","").replaceAll(" ",""));
            return arrayList;
        }
        else {
            stack.push(Character.toString(str2.charAt(i)));
            pickOrNot(stack, i+1, str2, arrayList);

            stack.pop();
            pickOrNot(stack, i+1, str2, arrayList);
        }
        return arrayList;
    }


    /*
    * 31. 김코딩은 모든 조별 발표 순서에 대한 경우의 수를 차례대로 구한 뒤 발표 순서를 말하면 이 발표 순서가 몇 번째 경우의 수인지를 대답해야 합니다.
    * 총 조의 수 N과 선생님이 말씀하시는 발표 순서 k가 주어질 때, 김코딩이 정답을 말 할 수 있게 올바른 리턴 값을 구하세요.
    * 모든 경우의 수가 담긴 배열은 번호가 작을수록 앞에 위치한다고 가정합니다.
    * ex) N = 3일경우, [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    * */
    public static int orderOfPresentation(int N, int[] K) {

        //발표 순서
        int order = 0;

        // 제일 첫 번째는 더미 데이터입니다. (인덱스는 0부터 시작하지만 조는 1부터 시작하기 때문에)
        boolean[] isUsed = new boolean[N+1];

        for (int i = 0; i<K.length; i++) {

            int num = K[i];

            isUsed[num] = true;

            // num 보다 앞에 올 수 있는 수들의 배열을 복사
            boolean[] candidates = Arrays.copyOfRange(isUsed, 1, num);
            int validCnt = 0;

            // 아직 사용되지 않은 수의 갯수를 구함
            for (boolean candidate : candidates) {
                if (!candidate)
                    validCnt++;
            }

            // 아직 사용되지 않은 수 전까지 모든 경우의 수를 카운트.
            int formerCnt = validCnt * factorial(N-i-1);

            // 발표 순서 업데이트
            order+=formerCnt;
        }


        return order;
    }




}


