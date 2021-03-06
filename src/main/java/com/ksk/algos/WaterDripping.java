package com.ksk.algos;

import java.util.Arrays;
import java.util.Scanner;

public class WaterDripping {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is " +
                findWater(arr, arr.length));

    }

    private static int findWater(int[] arr, int length) {
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int sum = 0;
        leftMax[0] = arr[0];
        System.out.println("lenth" + length);
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);
            System.out.println("t" + leftMax[i]);
        }
        rightMax[length-1] = arr[length-1];
        for (int j = length-1; j > rightMax.length; j--) {
            rightMax[j] = Math.max(arr[j],rightMax[length-j]);
            System.out.println("j" + rightMax[j]);
        }
        for (int k = 0; k < length; k++) {

        }
        return sum;
    }


}
