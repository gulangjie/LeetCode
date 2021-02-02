package com.leetCode;

/**
        回文数

     给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
     回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class Palindrome{
    public static void main(String[] args) {
        int num = 121;
        int num1 = 123;
        int num2 = 0x7fffffff;
        System.out.println(isPalindrome(num));
        System.out.println(isPalindrome(num1));
        System.out.println(isPalindrome(num2));
    }

    public static boolean isPalindrome(int x){
        int temp = x;

        if(temp < 0) return false;

        int change = 0;
        while(temp > 0){
            if(change > (Integer.MAX_VALUE  - temp % 10) / 10 ) return false;
            change = change * 10 + temp % 10;
            temp /= 10;
        }

        return x == change;
    }
}