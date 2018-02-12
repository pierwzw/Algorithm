package com.pier.algorithm.chap5_string;

/**
 * @author: pier
 * @date: 2018/2/12 23:39
 * @desc: 字符串中数字子串的求和
 */

public class AllNumbersSum {

    public static int getSum(String str){
        String[] digitalStr = str.split("\\D+");
        if (digitalStr.length == 0){
            return -1;
        }
        int sum = 0;
        for (String str1:digitalStr){
            if (!str1.equals("")){
                sum += Integer.valueOf(str1);
            }
        }
        return sum;
    }

    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        //防止最后一个是数字但是没有累加的情况
        res += num;
        return res;
    }

    public static void main(String[] args) {
        String test = "1K-100ABC500D-T--100F200G!!100H---300";
        System.out.println(numSum(test));

    }
}
