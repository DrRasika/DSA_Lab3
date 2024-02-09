import java.util.*;

public class BalancedBrackets {
    
    // Function to check if brackets are balanced
    public static boolean areBracketsBalanced(String expr) {
        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Traverse the given expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening bracket, then it must be closing. So stack cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // If stack is empty, then expression is balanced
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        // Sample input
        String input1 = "([{}])";
        String input2 = "([{}]";

        // Check if the brackets are balanced
        if (areBracketsBalanced(input1)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }

        if (areBracketsBalanced(input2)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }
}
