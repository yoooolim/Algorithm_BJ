import java.io.*;
import java.util.Stack;

public class BOJ_2504_ValueOfParentheses {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution(br.readLine());
    }
    private static void solution(String str){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(-2);
            else if (ch == '[') stack.push(-3);
            else if (ch == ')') {
                if (stack.isEmpty()) errorAlert();
                Integer now = stack.pop();
                if (now == -2) stack.push(2);
                else if (now == -3) errorAlert();
                else {
                    int partSum = now;
                    boolean find = false;
                    while (!stack.isEmpty()) {
                        now = stack.pop();
                        if (now == -2) {
                            find = true;
                            stack.push(partSum * 2);
                            break;
                        } else if (now > 0) partSum += now;
                        else errorAlert();
                    }
                    if (!find) errorAlert();
                }
            } else if (ch == ']') {
                if (stack.isEmpty()) errorAlert();
                Integer now = stack.pop();
                if (now == -3) stack.push(3);
                else if (now == -2) errorAlert();
                else {
                    int partSum = now;
                    boolean find = false;
                    while (!stack.isEmpty()) {
                        now = stack.pop();
                        if (now == -3) {
                            find = true;
                            stack.push(partSum * 3);
                            break;
                        } else if (now > 0) partSum += now;
                        else errorAlert();
                    }
                    if (!find) errorAlert();
                }
            }
            else errorAlert();
        }
        int sum = 0, temp = 0;
        while(!stack.isEmpty()) {
            if((temp = stack.pop())<0) errorAlert();
            else sum+=temp;
        }
        System.out.print(sum);
    }
    private static void errorAlert(){
        System.out.print(0);
        System.exit(0);
    }
}
