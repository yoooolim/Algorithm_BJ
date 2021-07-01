package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11660_PrefixSum5 {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        int arr[][]= new int[N][N];
        int dp[][] = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j]=Integer.parseInt(st.nextToken(" "));
        }
        dp[0][0]=arr[0][0];
        for(int i=1;i<N;i++){
            dp[i][0]=dp[i-1][0]+arr[i][0];
            dp[0][i]=dp[0][i-1]+arr[0][i];
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i][j]-dp[i-1][j-1];
            }
        }
        for(int i=0;i<M;i++){
            int x1=0,y1=0,x2=0,y2=0;
            st=new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken(" "))-1;
            y1=Integer.parseInt(st.nextToken(" "))-1;
            x2=Integer.parseInt(st.nextToken(" "))-1;
            y2=Integer.parseInt(st.nextToken(" "))-1;
            int ans = 0;
            if(x1==x2&&y1==y2) ans=arr[x1][y1];
            else if(x1==0&&y1==0) ans = dp[x2][y2];
            else if(x1==0) ans=dp[x2][y2]-dp[x2][y1-1];
            else if(y1==0) ans=dp[x2][y2]-dp[x1-1][y2];
            else ans = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}
