import java.util.*;

public class Balance {
    
    public static void balanced(String input){
        
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();


        if(input.isBlank()){
            System.out.println("1");
            return;
        }


        for (int i = 0; i < charArray.length; i++) {
            
            char cur = charArray[i];

            if(charArray[0] == ')' || charArray[0] == ']') {
                System.out.println("0");
                return;
            }

            if(cur == '(' || cur == '[') {
                stack.push(cur);
                continue;
            }

            if(stack.isEmpty()) {
                System.out.println("0");
                return;
            }

            if (cur == ')' || cur == ']') {
                if (stack.isEmpty()){
                    System.out.println("0");
                    return;
                }

                char last = stack.peek();
                if (cur == ')' && last == '(' || cur == ']' && last == '[') {
                    stack.pop();
                    continue;
                }
                else {
                    System.out.println("0");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("1");
            return;
        }
        else {
            System.out.println("0");
            return;
        }
    }

    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        sc.close();
        Balance.balanced(input);
    }
}
