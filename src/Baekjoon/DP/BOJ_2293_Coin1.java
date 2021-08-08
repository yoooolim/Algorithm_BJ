import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
첫번째 동전으로 만들 수 있는 가짓수 구하기
위의 수를 이용하여 두번째 동전으로 만들 수 있는 가짓수 구하기 ...
 */

public class BOJ_2293_Coin1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")); int k = Integer.parseInt(st.nextToken(" "));
        int [] coins = new int[n+1];

        for(int i=1;i<=n;i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);
        int [] dp = new int[k+1];
        dp[0]=1; // 자기 자신만으로 이루어진 것이 1가지 경우이기 때문에
        for(int i=1;i<=n;i++){
            for(int j=coins[i];j<=k;j++) dp[j] += dp[j - coins[i]];
        }
        System.out.println(dp[k]);
    }
}
