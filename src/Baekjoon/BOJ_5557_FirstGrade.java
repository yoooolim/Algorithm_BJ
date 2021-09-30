import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557_FirstGrade {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] dp;
    static int[] in;
    public static void main(String[] args) throws IOException {
        in = input();

        int wantToMake = in[in.length-1];
        long sum = solution(wantToMake,in.length-2);
        System.out.print(sum);
    }
    private static int[] input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] in = new int[N];
        dp = new long[N+1][21];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=20;j++) dp[i][j]=-1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for(int i=0;i<N;i++){
            in[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][in[0]] = 1;
        return in;
    }
    private static long solution(int make, int idx){
        if(idx==0&&in[0]==make) return 1;
        if(idx==0) return 0;

        if(dp[idx][make]!=-1) return dp[idx][make];
        dp[idx][make]=0;
        int want = make-in[idx];
        if(0<=want&&want<=20) dp[idx][make]+=solution(want,idx-1);
        want = make+in[idx];
        if(0<=want&&want<=20) dp[idx][make]+=solution(want,idx-1);
        return dp[idx][make];
    }
}
