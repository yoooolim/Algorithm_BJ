import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841_AlienPlayingGuitar_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken()), cnt=0;
        Stack<Integer>[] s = new Stack[N+1];
        for(int i=1;i<=N;i++) s[i] = new Stack<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            while(!s[n].isEmpty()){
                if(s[n].peek()>p) { s[n].pop(); cnt++; }
                else break;
            }
            if(s[n].isEmpty()||s[n].peek()<p){ s[n].push(p); cnt++; }
        }
        System.out.print(cnt);
    }
}
