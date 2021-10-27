import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_GoodWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), cnt = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            s.push(str.charAt(0));
            for(int j=1;j<str.length();j++) {
                char now = str.charAt(j);
                if(s.isEmpty()||s.peek()!=now) s.push(now);
                else s.pop();
            }
            if(s.isEmpty()) cnt++;
        }
        System.out.print(cnt);
    }
}
