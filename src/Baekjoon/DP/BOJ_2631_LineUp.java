import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
LIS 알고리즘 : 최장 증가하는 수열
 */
public class BOJ_2631_LineUp {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        int n = Integer.parseInt(br.readLine()); int max = 0;
        int[] children = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            children[i] = Integer.parseInt(br.readLine());
            dp[i]=1;
            for(int j=0;j<i;j++) { if(children[j]<children[i]&&dp[j]+1>dp[i]) dp[i]=dp[j]+1; }
            max = Math.max(max,dp[i]);
        }
        System.out.print(n-max);
    }
}
