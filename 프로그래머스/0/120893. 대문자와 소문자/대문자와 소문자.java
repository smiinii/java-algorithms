class Solution {
    public String solution(String my_string) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isUpperCase(my_string.charAt(i))) {
                stb.append(Character.toLowerCase(my_string.charAt(i)));
            }
            if (Character.isLowerCase(my_string.charAt(i))) {
                stb.append(Character.toUpperCase(my_string.charAt(i)));
            }
        }
        return stb.toString();
    }
}