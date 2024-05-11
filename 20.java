import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char b: s.toCharArray()){
            if(stack.size()>0&&stack.lastElement().equals(get(b))){
                stack.pop();
            }else{
                stack.add(b);
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }
    Character get(Character b){
        switch (b) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return null;
        }
    }
};