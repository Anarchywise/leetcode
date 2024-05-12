import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String string : tokens){
            if(is_operater(string)){
                String a = stack.pop();
                String b = stack.pop();
                stack.push(operate(a, b, string));
                System.out.println(stack.peek());
            }else{
                stack.push(string);
                System.out.println(stack.peek());
            }
        }
        return Integer.parseInt(stack.pop());
    }

    boolean is_operater(String string){
        switch (string) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    String operate(String a ,String b, String operator){
        int operand1 = Integer.parseInt(b);
        int operand2 = Integer.parseInt(a);
        switch (operator) {
            case "+":
                return String.valueOf(operand1 + operand2);
            case "-":
                return String.valueOf(operand1 - operand2);
            case "*":
                return String.valueOf(operand1 * operand2);
            case "/":
                if (operand2 == 0) {
                    return "0"; // 对除数为0的情况进行处理
                }
                return String.valueOf(operand1 / operand2);
            default:
                return null;
        }
    }
    
}