package Programmers;

import java.io.IOException;
import java.util.Stack;

public class P76502_ParenthesisRotation {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        String s = "[(])";
        System.out.print(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;
        sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(isRight()) answer++;
            rotate();
        }
        return answer;
    }
    static void rotate(){
        sb.append(sb.charAt(0));
        sb.delete(0,1);
    }
    static boolean isRight(){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<sb.length();i++){
            if(s.isEmpty()) s.push(sb.charAt(i));
            else{
                char chStack = s.peek();
                char ch = sb.charAt(i);
                if(ch==')'&&chStack=='(') s.pop();
                else if(ch==']'&&chStack=='[') s.pop();
                else if(ch=='}'&&chStack=='{') s.pop();
                else s.push(ch);
            }
        }
        if(s.isEmpty()) return true;
        return false;
    }
}
