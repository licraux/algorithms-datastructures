import edu.princeton.cs.algs4.Stack;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Balance2 {
    
    public static void main(String[] args) {

        
        //Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str = StdIn.readString();
        //sc.close();
        

        if (str.isEmpty()) {
            StdOut.print(1);
            return;
        }

        if (str.length() % 2 != 0){
            StdOut.print(0);
            return;
        }

        if (str.contains("(") && !(str.contains(")"))){
            StdOut.print(0);
            return;
        }

        if (str.contains("[") && !(str.contains("]"))){
            StdOut.print(0);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            
            if (current == '(' || current == '[') {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty()){
                StdOut.print(0);
                return;
            }

            if (current == ')' || current == ']') {
                if (stack.isEmpty()){
                    StdOut.print(0);
                    return;
                }

                char last = stack.peek();
                if (current == ')' && last == '(' || current == ']' && last == '[') {
                    stack.pop();
                    continue;
                }
                else {
                    StdOut.print(0);
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            StdOut.print(1);
            return;
        }
        else {
            StdOut.print(0);
            return;
        }
    }
}
