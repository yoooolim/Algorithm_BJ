import java.io.*;

public class BOJ_12852_MakeOne2 {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[1000001][2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[1][0]=0; dp[1][1]=0;
        for(int i=2;i<=N;i++){
            dp[i][0] = dp[i-1][0] + 1;
            dp[i][1] = i-1;
            if (i%2==0) {
                dp[i][0] = Math.min(dp[i][0], dp[i / 2][0]+1);
                if(dp[i][0]==dp[i/2][0]+1) dp[i][1]=i/2;
            }
            if (i%3==0) {
                dp[i][0] = Math.min(dp[i][0], dp[i / 3][0]+1);
                if(dp[i][0]==dp[i/3][0]+1) dp[i][1]=i/3;
            }
        }
        bw.write(String.valueOf(dp[N][0])+"\n");
        int nowIdx = N;
        while(nowIdx>0){
            bw.write(String.valueOf(nowIdx)+" ");
            nowIdx = dp[nowIdx][1];
        }
        bw.flush(); bw.close();
    }
}
