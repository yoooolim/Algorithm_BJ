import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
001 100 111
 */

public class BOJ_1904_01Tile {
    static final int divNum = 15746;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int make = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=make;i++) dp[i] = (dp[i-2] + dp[i-1])%divNum;
        System.out.print(dp[make]);
    }
}
