package com.leetCode;

public class GetNumberFromString {
    public static void main(String[] args) {
        String str = "1";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String s) {
        double result;
        int[] index = {-1,-1};
        String trimS = s.trim();
        if(trimS == null || trimS.equals("")) return 0;
        char[] chars = trimS.toCharArray();
        if(chars.length == 1){
            return chars[0] >= '0' && chars[0] <= '9' ? Integer.valueOf(chars[0] - '0') : 0;
        }
        if(!(chars[0] == '+' || chars[0] == '-' || (chars[0] >= '0' && chars[0] <= '9'))){
            return 0;
        }
        if(chars[0] < '0' && chars[0] > '9'){
            return 0;
        }
        if(chars[0] == '+'){
            index[0] = 1;
        }else if((chars[0] == '-')){
            index[0] = 0;
        }else if(chars[0] >= '0' && chars[0] <= '9'){
            index[0] = 0;
            index[1] = 0;
        }
        if((chars[0] == '-' || chars[0] == '+') && (chars[1] > '9' || chars[1] < '0')){
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                index[1] = i;
            }
            if(chars[i] > '9' || chars[i] < '0'){
                break;
            }
        }
        if(index[0] == -1 || index[1] == -1){return 0;}
        String temp = trimS.substring(index[0], index[1] + 1);
        result = Double.valueOf(temp);
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }

    public static int myAtoi1(String str){
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

}
