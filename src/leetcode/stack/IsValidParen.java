package leetcode.stack;

import java.util.Stack;

public class IsValidParen {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char current : s.toCharArray()) {
            if (current == '{' || current == '(' || current == '[') {
                //push all openers on to stack
                stack.push (current);
            } else {

                if (stack.isEmpty()
                        || (stack.peek() == '{' && current != '}')
                        || (stack.peek() == '(' && current != ')')
                        || (stack.peek() == '[' && current != ']')) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }

}
