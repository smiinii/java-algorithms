class Solution {
    public String solution(String rsp) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '2') {
                stb.append("0");
            } else if (rsp.charAt(i) == '0') {
                stb.append("5");
            } else if (rsp.charAt(i) == '5') {
                stb.append("2");
            } 
        }
        return stb.toString();
    }
}