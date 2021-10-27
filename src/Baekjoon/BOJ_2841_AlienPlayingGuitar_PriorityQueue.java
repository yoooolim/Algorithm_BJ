import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2841_AlienPlayingGuitar_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken()), cnt=0;
        PriorityQueue<Integer>[] q = new PriorityQueue[N+1];
        for(int i=1;i<=N;i++) q[i] = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            while(!q[n].isEmpty()){
                if(q[n].peek()>p) { q[n].poll(); cnt++; }
                else break;
            }
            if(q[n].isEmpty()||q[n].peek()<p){ q[n].offer(p); cnt++; }
        }
        System.out.print(cnt);
    }
}
