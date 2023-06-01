package codestates.coplit;

import java.awt.*;
import java.util.*;
import java.util.stream.IntStream;

public class recursive {
    public static void main(String[] args){

    }
    public int sumTo(int num){
        //base case
        if(num<=0) return 0;

        //recursive case
        return sumTo(num-1) + num;
    }

    public boolean isOdd(int num) {
        //base case
        if(num == 0) return false;
        if(num == 1) return true;

        //recursive case
        if(num<0) return isOdd(-num);
        return isOdd(num-2);
    }

    public int fibonacci(int num){
        //base case
        if(num<=1) return num;

        //recursive case
        return fibonacci(num-1) + fibonacci(num-2);
    }

    public int arrSum(int[] arr){
        //base case
        if(arr.length==0) return 0;

        //recursive case
        return arr[0] + arrSum(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public int arrProduct(int[] arr){
        //base case
        if(arr.length==0) return 1;

        //recursive case
        return arr[0] * arrProduct(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public int arrLength(int[] arr){
        //base case
        if(arr.length==0) return 0;

        //recursive case
        return 1 + arrLength(Arrays.copyOfRange(arr,1,arr.length));
    }

    public int[] drop(int num, int[] arr){
        //base case
        if(arr.length==0 || num == 0) return arr;

        //recursive case
        return drop(num - 1, Arrays.copyOfRange(arr,1,arr.length));
    }

    public int[] take(int num, int[] arr){
        //base case
        if(arr.length<=num) return arr; // 가져올 원소 갯수보다 배열의 길이가 더 짧은 경우
        if(arr.length==0 || num == 0) return new int[]{};

        //recursive case
        return take(num, Arrays.copyOfRange(arr,0,arr.length-1));
    }

    public static boolean and(boolean[] arr){
        //base case
        if(arr.length==0) return true;

        //recursive case
        if(arr[0]&&and(Arrays.copyOfRange(arr,1,arr.length))) return true;
        return false;
    }

    public boolean or(boolean[] arr){
        //base case
        if(arr.length==0) return false;

        //recursive case
        if(arr[0] || or(Arrays.copyOfRange(arr,1,arr.length))) return true;
        return false;
    }

    public int[] reverseArr(int[] arr){
        //base case
        if(arr.length==0) return new int[]{};


        //recursive case
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));
        int[] result =  new int[head.length+tail.length];
        System.arraycopy(head, 0, result, 0,head.length);
        System.arraycopy(tail, 0, result, head.length,tail.length);

        return result;
    }
}
