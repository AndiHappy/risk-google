package com.normal.alg.math;

public class Math {


    public String addStrings(String num1, String num2) {
        if(num2 == null || num2.equals("0")) return num1;
        if(num1== null || num1.equals("0")) return num2;

        int length = num1.length()> num2.length()? num1.length() : num2.length();
        int carry=0;int sum =0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int addv = num1.length()>i? num1.charAt((num1.length()-1-i))-'0':0;
            int resultv = num2.length()>i? num2.charAt((num2.length()-1-i))-'0':0;
            sum = addv+resultv+carry;
            carry = sum/10;
            result.insert(0,sum%10);
        }
        if(carry > 0) result.insert(0,carry);
        return result.toString();
    }


    public static void addBinary_test(String[] args) {
        System.out.println("keep happy,boy!");
        System.out.println(addBinary("11","1"));
    }

    // 1 <= a.length, b.length <= 104
    // a and b consist only of '0' or '1' characters.
    // Each string does not contain leading zeros except for the zero itself.

    public static String addBinary(String a, String b) {
        int length = a.length()>b.length()?a.length():b.length();
        StringBuilder result = new StringBuilder();
        int carry=0;
        for (int i = 0; i < length; i++) {
            int ai = a.length()>i? a.charAt(a.length()-1-i)-'0':0;
            int bi = b.length()>i? b.charAt(b.length()-1-i)-'0':0;
            int sum = ai+bi+carry;
            carry=sum/2;
            result.insert(0,sum%2);
        }
        if(carry>0) result.insert(0,carry);
        return result.toString();
    }


    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        // chars = [1,2,3]
        char[] chars = num1.toCharArray();
        String result = null;
        for (int i = 0; i < chars.length; i++) {
            String addValue = multiply(chars[chars.length-1-i],num2);
            addValue = appendValue(addValue,i);
            result = add(addValue,result);
        }
        return result;
    }

    private static String add(String addValue, String other) {
        if(other == null || other.equals("0")) return addValue;
        if(addValue== null || addValue.equals("0")) return other;

        int length = addValue.length()> other.length()? addValue.length() : other.length();
        int carry=0;int sum =0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int addv = addValue.length()>i? addValue.charAt((addValue.length()-1-i))-'0':0;
            int resultv = other.length()>i? other.charAt((other.length()-1-i))-'0':0;
            sum = addv+resultv+carry;
            carry = sum/10;
            result.insert(0,sum%10);
        }
        if(carry > 0) result.insert(0,carry);
        return result.toString();
    }


    private static String appendValue(String addValue, int i) {
        for (int j = 0; j < i; j++) {
            addValue+="0";
        }
        return addValue;
    }

    public static  String multiply(char num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry =0;int num1v = num1-'0';
        if(num1v == 1) return num2;
        int sum =0;
        for (int i = num2.length()-1; i >=0; i--) {
            int num2v = num2.charAt(i) - '0';
            sum = num1v*num2v+carry;
            carry = sum/10;
            builder.insert(0,sum%10);
        }
        if(carry>0){
            builder.insert(0,carry);
        }
        return builder.toString();
    }
}
