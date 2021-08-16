import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_Zoo {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        dp[1]=3;
        dp[2]=7;
        for(int i=3;i<n+1;i++) dp[i]=(dp[i-2] + dp[i-1]*2)%9901;
        //(a-1)*3 + (b-a)*2 +3 = a + 2b
        System.out.print(dp[n]);
    }
}
