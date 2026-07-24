import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        stack.add(s.charAt(0));
        
        if(stack.peek() == ')') {
            return false;
        }
            
        for(int i = 1; i < s.length(); i++) {
            if(!stack.isEmpty() && (s.charAt(i) != stack.peek())) {
                stack.pop();
            } else {
                if(s.charAt(i) == ')') {
                    return false;    
                }
                stack.add(s.charAt(i));
            }
        } // ())(
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}