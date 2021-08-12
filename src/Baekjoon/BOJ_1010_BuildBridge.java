import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1010_BuildBridge {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer>[] dp = calculate();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(c==0||m==0) sb.append(0+"\n");
            else sb.append(dp[m].get(c)+"\n");
        }
        System.out.print(sb);
    }
    private static ArrayList<Integer>[] calculate() throws IOException {
        ArrayList<Integer>[] dp = new ArrayList[31];
        for(int i=1;i<31;i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(1);
            for(int j=1;j<i;j++){
                dp[i].add(dp[i-1].get(j-1)+dp[i-1].get(j));
            }
            dp[i].add(1);
        }
        return dp;
    }
}
