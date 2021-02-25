package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11053 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] split = input.split(" ");
        int [] seq = new int[n];
        for(int i=0;i<n;i++) seq[i]=Integer.parseInt(split[i]);
        int [] dp = new int [n];
        dp[0]=1;
        int max = 1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(seq[i]>seq[j]&&dp[i]<=dp[j])
                    dp[i]=dp[j]+1;
            }
            max=Math.max(max,dp[i]);
            //if(max<dp[i]) max = dp[i];
            //이걸로 하면 틀리네.. 무슨 일이지ㅠㅠ
        }
        System.out.println(max);
    }
}
