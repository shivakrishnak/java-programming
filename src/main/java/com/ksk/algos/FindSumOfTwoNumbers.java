package com.ksk.algos;

//{1,2,4,5,7,8,9} - this is a sorted array ,
// try finding 2 numbers from this array whose sum is equal to 10 , no extra space and solve it in O(n)
public class FindSumOfTwoNumbers {
    public static void main(String[] args) {
        int[] input = {0, 1, 2, 4, 5, 7, 8, 9};
        int num = 8;
        //brute(input, num);
        check(input, num);
    }

    private static void check(int[] input, int num) {
        int start =0 , end = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[start] + " -- " + input[end]);
            if(input[start] + input[end] == num && start != end){
                System.out.println(input[start] + " <--> " + input[end]);
                start++;
                end--;
            } else if(input[start] + input[end] > num){
                end--;
            } else {
                start++;
            }
        }
    }

    private static void brute(int[] input, int num) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (num - input[i] == input[j]) {
                    System.out.println(input[i] + " -- " + input[j]);
                }
            }
        }
    }
}
