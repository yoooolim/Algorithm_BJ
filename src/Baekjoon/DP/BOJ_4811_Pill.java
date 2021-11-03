import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811_Pill {
    public static void main(String[] args) throws IOException {
        long[][] dp = new long[31][32];
        dp[1][2]=1;
        dp[1][0]=1;
        for(int i=2;i<=30;i++){
            long bfSum = dp[i-1][0];
            dp[i][2] = bfSum;
            dp[i][3] = bfSum;
            dp[i][0] = bfSum*2;
            for(int j=4;j<=i+1;j++){
                bfSum-=dp[i-1][j-2];
                dp[i][j] = bfSum;
                dp[i][0]+=bfSum;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        StringBuilder sb = new StringBuilder();
        while((input=Integer.parseInt(br.readLine()))!=0){
            sb.append(dp[input][0]+"\n");
        }
        System.out.print(sb);
    }
}
