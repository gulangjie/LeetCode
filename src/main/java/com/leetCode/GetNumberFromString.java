package com.leetCode;

public class GetNumberFromString {
    public static void main(String[] args) {
        String str = "";
        System.out.println(myAtoi(str));
        System.out.println((int)'9');
    }

    public static int myAtoi(String s) {
        int result = 0;
        int[] index = new int[2];
        String trimS = s.trim();
        char[] chars = trimS.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 45 && i < chars.length - 1 && chars[i+1] >= 48 && chars[i+1] <= 57){
                index[0] = i;
            }
            if(chars[i+1] >= 48 && chars[i+1] <= 57){
                index[0] = i;
            }
        }
        return result;
    }
}
