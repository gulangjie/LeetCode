package com.leetCode;

public class ReverseNumber {
    public static void main(String[] args) {
//        int x = 9646324351;
        System.out.println(reverse1(1534236469));
    }

    public static int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        long temp = 0;
        if(x == 0) return 0;
        int absx = Math.abs(x);
        while(absx > 0){
            temp = temp * 10 + absx % 10;
            absx = absx / 10;
        }
        long result = flag * temp;
        return (int) result == result ? (int)result : 0;
    }

    public static int reverse1(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
