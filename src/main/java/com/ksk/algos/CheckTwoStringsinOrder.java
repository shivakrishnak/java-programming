package com.ksk.algos;

//abcdefgh , acdef , u have to find the all the characters in second string are in main string in the same order
public class CheckTwoStringsinOrder {
    public static void main(String[] args) {
        String second = "abc";
        String main = "ahbgdc";
        //System.out.println(check(second, main));
        System.out.println(new CheckTwoStringsinOrder().isSubsequence(second, main));
    }

    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        while (tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                if (sIdx == s.length()) return true;
            }
            tIdx++;
        }
        return false;
    }

    private static boolean check(String second, String main) {
        if ("".equals(second)) return true;
        char[] mainStr = main.toCharArray();
        char[] secondStr = second.toCharArray();
        int mainArrIndex = 0, secondArrIndex = 0;
        for (int i = 0; i < mainStr.length; i++) {
            System.out.println(secondStr[secondArrIndex] + " <---> " + mainStr[mainArrIndex]);
            System.out.println(secondArrIndex + " --- " + mainArrIndex);
            if (secondStr[secondArrIndex] == mainStr[mainArrIndex]) {
                if (mainArrIndex < mainStr.length) mainArrIndex++;
                if (secondArrIndex < secondStr.length) secondArrIndex++;
                if (secondArrIndex == secondStr.length) {
                    return true;
                }
            } else {
                mainArrIndex++;
            }
        }
        return false;

    }
}
