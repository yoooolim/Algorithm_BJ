import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer memory = new StringTokenizer(br.readLine());
        StringTokenizer cost = new StringTokenizer(br.readLine());
        int[] memories = new int[N+1];
        int[] costs = new int[N+1];
        for(int i=1;i<=N;i++){
            memories[i] = Integer.parseInt(memory.nextToken());
            costs[i] = Integer.parseInt(cost.nextToken());
        }

        int minCost = Integer.MAX_VALUE;
        int[][] dp = new int[N+1][10001]; //행 : 몇번째 앱까지 고려하였는지, 열 : c의 합, 값 : 메모리 최대값
        for(int i=0;i<=N;i++) dp[i][0]=1;
        for(int i=0;i<=N;i++){
            System.out.print("");
            for(int j=0;j<=10000;j++){
                if(i==0&&j>=costs[i]) dp[i][j]=memories[i];
                else if(j<costs[i]) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j-costs[i]]+memories[i],dp[i-1][j]);
                if(dp[i][j]>=M) minCost = Math.min(minCost,j);
            }
        }
        System.out.print(minCost);
    }
}
