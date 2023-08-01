class Solution {
    public static int solution(int number, int limit, int power) {
        int[] powerOfNumbers = new int[number + 1];
        int sum = 0;

        for (int num = 1; num <= number; num++) {
            int divisor = countOfDivisor(num);
            powerOfNumbers[num] = divisor > limit ? power : divisor;
            sum += powerOfNumbers[num];
        }

        return sum;
    }

    private static int countOfDivisor(int num) {
        int divisorCount = 0;

        // 절반까지만 계산 
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                divisorCount++;
            } else if (num % i == 0) {
                divisorCount += 2;
            }
        }

        return divisorCount;
    }

}