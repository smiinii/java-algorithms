import java.util.*;
class Solution {
    public String solution(int age) {
        String strAge = String.valueOf(age);
        char[] result = new char[strAge.length()];
        for (int i = 0; i < strAge.length(); i++) {
            if (strAge.charAt(i) == '0') {
                result[i] = 'a';
            } else if (strAge.charAt(i) == '1') {
                result[i] = 'b';
            } else if (strAge.charAt(i) == '2') {
                result[i] = 'c';
            } else if (strAge.charAt(i) == '3') {
                result[i] = 'd';
            } else if (strAge.charAt(i) == '4') {
                result[i] = 'e';
            } else if (strAge.charAt(i) == '5') {
                result[i] = 'f';
            } else if (strAge.charAt(i) == '6') {
                result[i] = 'g';
            } else if (strAge.charAt(i) == '7') {
                result[i] = 'h';
            } else if (strAge.charAt(i) == '8') {
                result[i] = 'i';
            } else if (strAge.charAt(i) == '9') {
                result[i] = 'j';
            }
        }
        return String.valueOf(result);
    }
}