package com.ksk.algos;

import java.util.Arrays;
import java.util.stream.IntStream;

//{1,2,3,4,5} - this is an array - return an array ( 120, 60,40,30,24 } , at index i ,
// u have to have product the numbers at other indices
public class FindProductAtOtherIndices {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4,5};
        //brute(input);
        //brute2(input);
        checkWithExtraSpace(input);
        //check(input);
    }

    private static void check(int[] input) {
        int[] finalArray = new int[input.length];
        int beforeSum = 1, afterSum = 1;
        int length = input.length - 1;
        int backIndex = length;
        for (int i = 0; i < input.length; i++) {
            if(finalArray[i] == 0 && afterSum != 0) finalArray[i] = 1;
            if(finalArray[backIndex] == 0  && beforeSum != 0) finalArray[backIndex] = 1;
            //System.out.println(Arrays.toString(finalArray));

            finalArray[i] *= beforeSum;
            finalArray[backIndex] *= afterSum;
            //System.out.println(beforeSum + " --- " + afterSum);

            beforeSum *= input[i];
            afterSum *= input[backIndex];
            backIndex--;
        }
        System.out.println(Arrays.toString(finalArray));
    }

    private static void checkWithExtraSpace(int[] input) {
        int[] beforeSumArray = new int[input.length];
        int beforeSum = 1;
        for (int i = 0; i < input.length; i++) {
            beforeSumArray[i] = beforeSum;
            beforeSum *= input[i];
        }
        System.out.println(Arrays.toString(beforeSumArray));

        int[] afterSumArray = new int[input.length];
        int afterSum = 1;
        for (int i = input.length - 1 ; i >= 0; i--) {
            afterSumArray[i] = afterSum;
            afterSum *= input[i];
        }
        System.out.println(Arrays.toString(afterSumArray));
        int[] finalArray = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            finalArray[i] = beforeSumArray[i] * afterSumArray[i];
        }
        System.out.println(Arrays.toString(finalArray));
    }

    private static void brute2(int[] input) {
        int[] op = new int[input.length];
        IntStream.range(0, input.length).forEach(i -> op[i] = 1);
        //System.out.println(Arrays.toString(op));
        for (int i = 0; i < op.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j) {
                    op[i] *= input[j];
                    //System.out.println(i + " -- " + j);
                }
            }
        }
        System.out.println(Arrays.toString(op));
    }

    private static void brute(int[] input) {
        int[] op = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int sum = 1;
            for (int j = 0; j < input.length; j++) {
                if (i != j) {
                    if (input[j] == 0) {
                        sum = 0;
                        break;
                    }
                    sum *= input[j];
                }
            }
            op[i] = sum;
        }
        System.out.println(Arrays.toString(op));
    }
}
